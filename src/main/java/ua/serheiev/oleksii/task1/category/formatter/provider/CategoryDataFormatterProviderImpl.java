package ua.serheiev.oleksii.task1.category.formatter.provider;

import ua.serheiev.oleksii.task1.category.formatter.CategoryDataFormatter;

import java.util.Map;

public class CategoryDataFormatterProviderImpl implements CategoryDataFormatterProvider {

    private Map<String, CategoryDataFormatter> categoryDataFormatters;

    public CategoryDataFormatterProviderImpl(Map<String, CategoryDataFormatter> categoryDataFormatters) {
        this.categoryDataFormatters = categoryDataFormatters;
    }

    @Override
    public CategoryDataFormatter getFormatter(String categoryName) {
        return categoryDataFormatters.get(categoryName);
    }
}
