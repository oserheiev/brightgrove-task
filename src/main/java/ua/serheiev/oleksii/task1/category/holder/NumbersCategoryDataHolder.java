package ua.serheiev.oleksii.task1.category.holder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumbersCategoryDataHolder implements CategoryDataHolder<Map<String, Long>> {

    private Map<String, Long> dataItemFrequencyPairs = new HashMap<>();

    @Override
    public void add(String dataItem) {
        Long frequency = dataItemFrequencyPairs.getOrDefault(dataItem, 0L);
        dataItemFrequencyPairs.put(dataItem, ++frequency);
    }

    @Override
    public Map<String, Long> getAll() {
        return Collections.unmodifiableMap(dataItemFrequencyPairs);
    }
}
