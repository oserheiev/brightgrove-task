package ua.serheiev.oleksii.task1.category.holder;

import org.junit.Before;
import org.junit.Test;
import ua.serheiev.oleksii.task1.constant.Const.Category;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CategoryDataHolderProviderImplTest {

    private static final String NONE_EXISTING_CATEGORY_NAME = "none_xisting_category";
    private CategoryDataHolderProviderImpl categoryDataHolderProvider;

    @Before
    public void setUp() throws Exception {
        Map<String, CategoryDataHolder> dataHolders = Collections.singletonMap(Category.ANIMALS,
                new AnimalsCategoryDataHolder());
        categoryDataHolderProvider = new CategoryDataHolderProviderImpl(dataHolders);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenCategoryDataHolderIsNotFound() {
        Optional<CategoryDataHolder> optional = categoryDataHolderProvider.getHolder(NONE_EXISTING_CATEGORY_NAME);
        assertFalse(optional.isPresent());
    }

    @Test
    public void shouldReturnOptionalWithHolderWhenDataHolderIsFound() {
        Optional<CategoryDataHolder> optional = categoryDataHolderProvider.getHolder(Category.ANIMALS);
        assertTrue(optional.isPresent());
    }
}