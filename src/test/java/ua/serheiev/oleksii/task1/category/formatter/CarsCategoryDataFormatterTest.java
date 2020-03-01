package ua.serheiev.oleksii.task1.category.formatter;

import org.junit.Test;
import ua.serheiev.oleksii.task1.constant.Const;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CarsCategoryDataFormatterTest {

    private CarsCategoryDataFormatter carsCategoryDataFormatter = new CarsCategoryDataFormatter();

    @Test
    public void shouldReturnOnlyCategoryNameWithColonWhenDataItemsAreEmpty() {
        String actual = carsCategoryDataFormatter.format(Const.Category.CARS, Collections.emptySet());
        String expected = "CARS:" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedDataItemsInReverseOrderWhenDataItemsArePresent() {
        Set<String> dataItems = new HashSet<>();
        dataItems.add("bmw");
        dataItems.add("opel");

        String actual = carsCategoryDataFormatter.format(Const.Category.CARS, dataItems);
        String expected = "CARS:" + System.lineSeparator() +
                "§ opel (f65b7d39472c52142ea2f4ea5e115d59)" + System.lineSeparator() +
                "§ bmw (71913f59e458e026d6609cdb5a7cc53d)" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}