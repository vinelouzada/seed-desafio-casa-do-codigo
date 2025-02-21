package vinelouzada.cdc.category.dto;

import jakarta.validation.constraints.NotBlank;
import vinelouzada.cdc.category.Category;

public record CreateCategoryRequest(@NotBlank String name) {
    public Category toModel(){
        return new Category(name);
    }
}