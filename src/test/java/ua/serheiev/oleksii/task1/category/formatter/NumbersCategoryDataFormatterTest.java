package ua.serheiev.oleksii.task1.category.formatter;

import org.junit.Test;
import ua.serheiev.oleksii.task1.constant.Const;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NumbersCategoryDataFormatterTest {

    private NumbersCategoryDataFormatter numbersCategoryDataFormatter = new NumbersCategoryDataFormatter();

    @Test
    public void shouldReturnDataItemsWithTheirFrequencySplitByColonWhenDataItemsArePresent() {
        Map<String, Long> dataItemsWithFrequency = new LinkedHashMap<>();
        dataItemsWithFrequency.put("seven", 7L);
        dataItemsWithFrequency.put("fifty", 50L);

        String actual = numbersCategoryDataFormatter.format(Const.Category.NUMBERS, dataItemsWithFrequency);
        String expected = "NUMBERS:" + System.lineSeparator() +
                "seven:7" + System.lineSeparator() +
                "fifty:50" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnOnlyCategoryWithColonWhenDataItemsAreEmpty() {
        String actual = numbersCategoryDataFormatter.format(Const.Category.NUMBERS, Collections.emptyMap());
        String expected = "NUMBERS:" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}