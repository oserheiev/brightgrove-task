package ua.serheiev.oleksii.task1.category.holder;

import java.util.Map;
import java.util.Optional;

public interface CategoryDataHolderProvider {

    /**
     * Provides {@link CategoryDataHolder} by category name if present.
     *
     * @param categoryName category name in upper-case.
     * @return category data holder optional.
     */
    Optional<CategoryDataHolder> getHolder(String categoryName);

    /**
     * Provides all available {@link CategoryDataHolder}'s with a category name key.
     *
     * @return category name and category data holder map or empty map.
     */
    Map<String, CategoryDataHolder> getHolders();
}
