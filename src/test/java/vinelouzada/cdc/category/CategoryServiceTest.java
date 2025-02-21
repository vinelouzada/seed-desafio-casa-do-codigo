package vinelouzada.cdc.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vinelouzada.cdc.exceptions.NameAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private Category category;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepository);
        category = new Category("Technology");
    }

    @Test
    void save__should_throw_exception_when_category_name_already_exists() {
        when(categoryRepository.existsByName(category.getName())).thenReturn(true);

        assertThrows(NameAlreadyExistsException.class, () -> categoryService.save(category));
        verify(categoryRepository, never()).save(category);
    }

    @Test
    void save__should_save_category_when_category_name_does_not_exist() {
        when(categoryRepository.existsByName(category.getName())).thenReturn(false);

        assertDoesNotThrow(() -> categoryService.save(category));
        verify(categoryRepository, times(1)).save(category);
    }
}