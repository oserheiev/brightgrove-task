package ua.serheiev.oleksii.task1.category.formatter;

public interface CategoryDataFormatter<T> {

    /**
     * Formats category data.
     *
     * @param categoryName category name.
     * @param categoryData nonnull category data.
     * @return formatted category data or category name with a colon.
     */
    String format(String categoryName, T categoryData);
}
