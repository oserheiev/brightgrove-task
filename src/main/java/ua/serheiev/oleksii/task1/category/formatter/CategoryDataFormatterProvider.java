package ua.serheiev.oleksii.task1.category.formatter;

public interface CategoryDataFormatterProvider {

    /**
     * Provides {@link CategoryDataFormatter} by a category name if present.
     *
     * @param categoryName category name in upper-case.
     * @return category data formatter or null.
     */
    CategoryDataFormatter getFormatter(String categoryName);
}
