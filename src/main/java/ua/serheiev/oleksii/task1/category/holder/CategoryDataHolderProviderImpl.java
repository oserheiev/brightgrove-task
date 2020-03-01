package ua.serheiev.oleksii.task1.category.holder;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class CategoryDataHolderProviderImpl implements CategoryDataHolderProvider {

    private Map<String, CategoryDataHolder> categoryDataHolders;

    public CategoryDataHolderProviderImpl(Map<String, CategoryDataHolder> categoryDataHolders) {
        this.categoryDataHolders = categoryDataHolders;
    }

    @Override
    public Optional<CategoryDataHolder> getHolder(String categoryName) {
        return Optional.ofNullable(categoryDataHolders.get(categoryName));
    }

    @Override
    public Map<String, CategoryDataHolder> getHolders() {
        return Collections.unmodifiableMap(categoryDataHolders);
    }
}
