package ua.serheiev.oleksii.task1.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.serheiev.oleksii.task1.category.formatter.CategoryDataFormatter;
import ua.serheiev.oleksii.task1.category.formatter.CategoryDataFormatterProvider;
import ua.serheiev.oleksii.task1.category.holder.CategoryDataHolder;
import ua.serheiev.oleksii.task1.category.holder.CategoryDataHolderProvider;
import ua.serheiev.oleksii.task1.constant.Const.Category;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    private static final String ANIMALS_DATA_ITEM = "cow";
    public static final String FORMATTED_DATA_ITEMS = "ANIMALS:" + System.lineSeparator() + "cow" + System.lineSeparator() + "horse";

    @Mock
    private CategoryDataFormatterProvider categoryDataFormatterProvider;
    @Mock
    private CategoryDataHolderProvider categoryDataHolderProvider;
    @Mock
    private CategoryDataHolder categoryDataHolder;
    @Mock
    private CategoryDataFormatter categoryDataFormatter;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void shouldNotAddDataItemWhenCategoryItemIsPassed() {
        when(categoryDataHolderProvider.getHolder(Category.ANIMALS)).thenReturn(Optional.of(categoryDataHolder));

        categoryService.process(Category.ANIMALS);
        verify(categoryDataHolder, never()).add(Category.ANIMALS.toLowerCase());
    }

    @Test
    public void shouldAddDataItemWhenDataItemIsNotCategory() {
        when(categoryDataHolderProvider.getHolder(Category.ANIMALS)).thenReturn(Optional.of(categoryDataHolder));
        when(categoryDataHolderProvider.getHolder(ANIMALS_DATA_ITEM.toUpperCase())).thenReturn(Optional.empty());

        categoryService.process(Category.ANIMALS);
        categoryService.process(ANIMALS_DATA_ITEM);

        verify(categoryDataHolder).add(ANIMALS_DATA_ITEM);
    }

    @Test
    public void shouldIgnoreDataItemWhenCategoryIsNotAppearedYet() {
        when(categoryDataHolderProvider.getHolder(ANIMALS_DATA_ITEM.toUpperCase())).thenReturn(Optional.empty());

        categoryService.process(ANIMALS_DATA_ITEM);

        verify(categoryDataHolder, never()).add(ANIMALS_DATA_ITEM);
    }

    @Test
    public void shouldReturnFormattedCategoryDataWhenCategoryDataHoldersArePresent() {
        Map<String, CategoryDataHolder> dataHolders = Collections.singletonMap(Category.ANIMALS, categoryDataHolder);
        Set<String> dataItems = new HashSet<>();
        dataItems.add("horse");
        dataItems.add("cow");

        when(categoryDataHolderProvider.getHolders()).thenReturn(dataHolders);
        when(categoryDataFormatterProvider.getFormatter(Category.ANIMALS)).thenReturn(categoryDataFormatter);
        when(categoryDataHolder.getAll()).thenReturn(dataItems);
        when(categoryDataFormatter.format(Category.ANIMALS, dataItems)).thenReturn(FORMATTED_DATA_ITEMS);

        assertEquals(FORMATTED_DATA_ITEMS, categoryService.format());
    }
}