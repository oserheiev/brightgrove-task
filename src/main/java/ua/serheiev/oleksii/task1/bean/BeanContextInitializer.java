package ua.serheiev.oleksii.task1.bean;

import ua.serheiev.oleksii.task1.category.formatter.AnimalsCategoryDataFormatter;
import ua.serheiev.oleksii.task1.category.formatter.CarsCategoryDataFormatter;
import ua.serheiev.oleksii.task1.category.formatter.CategoryDataFormatter;
import ua.serheiev.oleksii.task1.category.formatter.NumbersCategoryDataFormatter;
import ua.serheiev.oleksii.task1.category.formatter.provider.CategoryDataFormatterProvider;
import ua.serheiev.oleksii.task1.category.formatter.provider.CategoryDataFormatterProviderImpl;
import ua.serheiev.oleksii.task1.category.holder.CategoryDataHolder;
import ua.serheiev.oleksii.task1.category.holder.NumbersCategoryDataHolder;
import ua.serheiev.oleksii.task1.category.holder.UniqueItemsCategoryDataHolder;
import ua.serheiev.oleksii.task1.category.holder.provider.CategoryDataHolderProvider;
import ua.serheiev.oleksii.task1.category.holder.provider.CategoryDataHolderProviderImpl;
import ua.serheiev.oleksii.task1.constant.Const;
import ua.serheiev.oleksii.task1.service.CategoryService;
import ua.serheiev.oleksii.task1.service.CategoryServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class BeanContextInitializer {

    public BeanContext initContext() {
        BeanContext context = new BeanContext();

        Map<String, CategoryDataHolder> categoryDataHolders = new HashMap<>();
        categoryDataHolders.put(Const.Category.ANIMALS, new UniqueItemsCategoryDataHolder());
        categoryDataHolders.put(Const.Category.NUMBERS, new NumbersCategoryDataHolder());
        categoryDataHolders.put(Const.Category.CARS, new UniqueItemsCategoryDataHolder());
        CategoryDataHolderProvider categoryDataHolderProvider = new CategoryDataHolderProviderImpl(categoryDataHolders);

        Map<String, CategoryDataFormatter> categoryDataFormatters = new HashMap<>();
        categoryDataFormatters.put(Const.Category.ANIMALS, new AnimalsCategoryDataFormatter());
        categoryDataFormatters.put(Const.Category.NUMBERS, new NumbersCategoryDataFormatter());
        categoryDataFormatters.put(Const.Category.CARS, new CarsCategoryDataFormatter());
        CategoryDataFormatterProvider categoryDataFormatterProvider = new CategoryDataFormatterProviderImpl(categoryDataFormatters);

        CategoryService categoryService = new CategoryServiceImpl(categoryDataHolderProvider,
                categoryDataFormatterProvider);

        context.putBean(CategoryService.class.getName(), categoryService);
        return context;
    }
}
