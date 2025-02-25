package vinelouzada.cdc.category;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import vinelouzada.cdc.exceptions.NameAlreadyExistsException;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        if (categoryRepository.existsByName(category.getName())) throw new NameAlreadyExistsException();

        return categoryRepository.save(category);
    }

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(EntityNotFoundException::new);
    }
}