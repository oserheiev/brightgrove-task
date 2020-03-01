package ua.serheiev.oleksii.task1.category.holder;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumbersCategoryDataHolderTest {

    private NumbersCategoryDataHolder numbersCategoryDataHolder = new NumbersCategoryDataHolder();

    @Test
    public void shouldReturnMapWithFrequencyTwoForDataItemWhenDataItemIsAddedTwice() {
        numbersCategoryDataHolder.add("cow");
        numbersCategoryDataHolder.add("cow");

        Map<String, Long> actual = numbersCategoryDataHolder.getAll();
        Map<String, Long> expected = Collections.singletonMap("cow", 2L);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyMapWhenDataItemsAreNotAddedYet() {
        assertTrue(numbersCategoryDataHolder.getAll().isEmpty());
    }
}