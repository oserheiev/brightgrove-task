package ua.serheiev.oleksii.task1.category.holder;

public interface CategoryDataHolder<T> {

    /**
     * Adds category data items depending on business requirements.
     *
     * @param dataItem none-black category data.
     */
    void add(String dataItem);

    /**
     * Return collected category data items.
     *
     * @return collected category data items.
     */
    T getAll();

    /**
     * Clear all saved data items.
     */
    void clear();
}
