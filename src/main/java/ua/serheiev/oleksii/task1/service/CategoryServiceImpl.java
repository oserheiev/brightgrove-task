package ua.serheiev.oleksii.task1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.serheiev.oleksii.task1.category.formatter.CategoryDataFormatter;
import ua.serheiev.oleksii.task1.category.formatter.CategoryDataFormatterProvider;
import ua.serheiev.oleksii.task1.category.holder.CategoryDataHolder;
import ua.serheiev.oleksii.task1.category.holder.CategoryDataHolderProvider;

import java.util.Map;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private CategoryDataHolderProvider categoryDataHolderProvider;
    private CategoryDataFormatterProvider categoryDataFormatterProvider;

    private CategoryDataHolder categoryDataHolder;

    public CategoryServiceImpl(CategoryDataHolderProvider categoryDataHolderProvider,
                               CategoryDataFormatterProvider categoryDataFormatterProvider) {
        this.categoryDataHolderProvider = categoryDataHolderProvider;
        this.categoryDataFormatterProvider = categoryDataFormatterProvider;
    }

    @Override
    public void process(String dataItem) {
        String categoryName = dataItem.toUpperCase();
        Optional<CategoryDataHolder> categoryDataHolderOptional = categoryDataHolderProvider.getHolder(categoryName);

        if (categoryDataHolderOptional.isPresent()) {
            categoryDataHolder = categoryDataHolderOptional.get();
            return;
        }
        addCategoryDataItem(dataItem);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String format() {
        Map<String, CategoryDataHolder> categoryDataHolders = categoryDataHolderProvider.getCategoryHoldersMap();
        StringBuilder stringBuilder = new StringBuilder();

        categoryDataHolders.forEach((categoryName, categoryDataHolder) -> {
            CategoryDataFormatter categoryDataFormatter = categoryDataFormatterProvider.getFormatter(categoryName);
            Object categoryData = categoryDataHolder.getAll();
            String formattedCategoryData = categoryDataFormatter.format(categoryName, categoryData);
            stringBuilder.append(formattedCategoryData);
        });
        return stringBuilder.toString();
    }

    @Override
    public void clear() {
        categoryDataHolderProvider.getHolders().forEach(CategoryDataHolder::clear);
    }

    private void addCategoryDataItem(String dataItem) {
        if (nonNull(categoryDataHolder)) {
            categoryDataHolder.add(dataItem.toLowerCase());
            return;
        }
        LOGGER.warn("The data item {} is skipped due to a category is not appeared yet", dataItem);
    }
}
