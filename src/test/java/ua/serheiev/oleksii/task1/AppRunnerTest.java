package ua.serheiev.oleksii.task1;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.serheiev.oleksii.task1.service.CategoryService;

import java.io.BufferedWriter;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppRunnerTest {

    @Mock
    private CategoryService categoryService;
    @Mock
    private BufferedWriter bufferedWriter;

    @Spy
    @InjectMocks
    private AppRunner appRunner;

    @Before
    public void setUp() {
        when(appRunner.prepareBufferedConsoleWriter()).thenReturn(bufferedWriter);
    }

    @Test
    public void shouldCallCategoryServiceProcessWithReadDataItemWhenDataItemIsNotEmpty() {
        appRunner.run(new String[]{"input.txt"});
        verify(categoryService).process("seven");
    }

    @Test
    public void shouldShouldNotCallCategoryServiceProcessWhenDataItemIsEmpty() {
        appRunner.run(new String[]{"input.txt"});
        verify(categoryService, never()).process(StringUtils.EMPTY);
    }
}