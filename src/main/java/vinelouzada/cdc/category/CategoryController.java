package vinelouzada.cdc.category;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.category.dto.CreateCategoryRequest;
import vinelouzada.cdc.category.dto.CreateCategoryResponse;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCategoryResponse> create(@RequestBody @Valid CreateCategoryRequest request) {
        Category category = categoryService.save(request.toModel());

        return ResponseEntity.ok(new CreateCategoryResponse(category));
    }
}
