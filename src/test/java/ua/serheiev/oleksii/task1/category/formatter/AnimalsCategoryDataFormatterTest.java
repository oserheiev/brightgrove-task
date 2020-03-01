package ua.serheiev.oleksii.task1.category.formatter;

import org.junit.Test;
import ua.serheiev.oleksii.task1.constant.Const.Category;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AnimalsCategoryDataFormatterTest {

    private AnimalsCategoryDataFormatter animalsCategoryDataFormatter = new AnimalsCategoryDataFormatter();

    @Test
    public void shouldReturnSortedDataItemsWithCategoryNameWhenDataItemsArePresent() {
        Set<String> dataItems = new HashSet<>();
        dataItems.add("horse");
        dataItems.add("cow");

        String actual = animalsCategoryDataFormatter.format(Category.ANIMALS, dataItems);
        String expected = "ANIMALS:" + System.lineSeparator() +
                "cow" + System.lineSeparator() +
                "horse" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnOnlyCategoryNameWithColonWhenDataItemsAreEmpty() {
        String actual = animalsCategoryDataFormatter.format(Category.ANIMALS, Collections.emptySet());
        String expected = "ANIMALS:" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}