package ua.serheiev.oleksii.task1;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.serheiev.oleksii.task1.bean.BeanContext;
import ua.serheiev.oleksii.task1.bean.BeanContextInitializer;
import ua.serheiev.oleksii.task1.service.CategoryService;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AppRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class.getName());

    private static final String[] INPUT_FILE_NAMES = {"input.txt", "input2.txt"};

    private CategoryService categoryService;

    public AppRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public static void main(String[] args) {
        BeanContextInitializer contextInitializer = new BeanContextInitializer();
        BeanContext beanContext = contextInitializer.initContext();
        CategoryService categoryService = beanContext.getBean(CategoryService.class.getName());

        AppRunner appRunner = new AppRunner(categoryService);
        appRunner.run(INPUT_FILE_NAMES);
    }

    public void run(String[] inputFileNames) {
        try (BufferedWriter displayWriter = prepareBufferedConsoleWriter()) {
            for (String fileName : inputFileNames) {
                processFiles(displayWriter, fileName, inputFileNames);
            }
        } catch (IOException e) {
            LOGGER.error("Cannot print category data items", e);
        }
    }

    private void processFiles(BufferedWriter displayWriter, String fileName, String[] inputFileNames) throws IOException {
            File file = getFile(fileName);

            if (file.exists()) {
                processFileCategoryData(file);
                displayCategoryData(displayWriter);
                categoryService.clear();
                return;
            }
            LOGGER.warn("Cannot add the file {} due to it does not exists", fileName);
    }

    private File getFile(String fileName) {
        URL resource = AppRunner.class.getClassLoader().getResource(fileName);
        return new File(resource.getFile());
    }

    private void displayCategoryData(BufferedWriter displayWriter) throws IOException {
        String categoryData = categoryService.format();
        displayWriter.write(categoryData);
        displayWriter.write(System.lineSeparator());
    }

    private void processFileCategoryData(File file) {
        try (BufferedReader bufferedReader = prepareBufferedFileReader(file)) {
            String fileLine = null;

            while ((fileLine = bufferedReader.readLine()) != null ) {
                processCategoryDataIfNotEmpty(fileLine);
            }
        } catch (IOException e) {
            LOGGER.error("Cannot add the file {}", file.getAbsolutePath(), e);
        }
    }

    private void processCategoryDataIfNotEmpty(String fileLine) {
        String dataItem = fileLine.trim();

        if (StringUtils.isNotEmpty(dataItem)) {
            categoryService.process(dataItem);
        }
    }

    @VisibleForTesting
    BufferedWriter prepareBufferedConsoleWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
    }

    private BufferedReader prepareBufferedFileReader(File file) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    }
}
