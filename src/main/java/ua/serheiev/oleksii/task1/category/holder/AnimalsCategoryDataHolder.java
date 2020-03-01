package ua.serheiev.oleksii.task1.category.holder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AnimalsCategoryDataHolder implements CategoryDataHolder<Set<String>> {

    private Set<String> dataItems = new HashSet<>();

    @Override
    public void add(String dataItem) {
        dataItems.add(dataItem);
    }

    @Override
    public Set<String> getAll() {
        return Collections.unmodifiableSet(dataItems);
    }

    @Override
    public void clear() {
        dataItems.clear();
    }
}
