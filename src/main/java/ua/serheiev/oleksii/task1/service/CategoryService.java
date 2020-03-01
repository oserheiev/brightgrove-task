package ua.serheiev.oleksii.task1.service;

import ua.serheiev.oleksii.task1.category.holder.CategoryDataHolder;

public interface CategoryService {

    /**
     * Processes a category data item depending on available {@link CategoryDataHolder}'s.
     *
     * if a passed data item represents a category then the appropriate {@link CategoryDataHolder} is set
     * and will be used to handle further data items.
     * if a passed data item represents category data then the data item is passed to {@link CategoryDataHolder}
     * to handle it.
     *
     *
     * @param dataItem category data or category name.
     */
    void process(String dataItem);

    /**
     * Returns processed category data representation for available {@link CategoryDataHolder}.
     *
     * @return processed category data representation or empty string.
     */
    String format();
}
