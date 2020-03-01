package ua.serheiev.oleksii.task1.bean;

import ua.serheiev.oleksii.task1.category.formatter.*;
import ua.serheiev.oleksii.task1.category.holder.*;
import ua.serheiev.oleksii.task1.constant.Const;
import ua.serheiev.oleksii.task1.service.CategoryService;
import ua.serheiev.oleksii.task1.service.CategoryServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class BeanContextInitializer {

    public BeanContext initContext() {
        BeanContext context = new BeanContext();

        Map<String, CategoryDataHolder> categoryDataHolders = new HashMap<>();
        categoryDataHolders.put(Const.Category.ANIMALS, new AnimalsCategoryDataHolder());
        categoryDataHolders.put(Const.Category.NUMBERS, new NumbersCategoryDataHolder());
        CategoryDataHolderProvider categoryDataHolderProvider = new CategoryDataHolderProviderImpl(categoryDataHolders);

        Map<String, CategoryDataFormatter> categoryDataFormatters = new HashMap<>();
        categoryDataFormatters.put(Const.Category.ANIMALS, new AnimalsCategoryDataFormatter());
        categoryDataFormatters.put(Const.Category.NUMBERS, new NumbersCategoryDataFormatter());
        CategoryDataFormatterProvider categoryDataFormatterProvider = new CategoryDataFormatterProviderImpl(categoryDataFormatters);

        CategoryService categoryService = new CategoryServiceImpl(categoryDataHolderProvider,
                categoryDataFormatterProvider);

        context.putBean(CategoryService.class.getName(), categoryService);
        return context;
    }
}
