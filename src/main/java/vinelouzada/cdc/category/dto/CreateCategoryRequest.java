package vinelouzada.cdc.category.dto;

import jakarta.validation.constraints.NotBlank;
import vinelouzada.cdc.category.Category;
import vinelouzada.cdc.shared.UniqueValue;

public record CreateCategoryRequest(
        @NotBlank
        @UniqueValue(field = "name", domainClass = Category.class)
        String name
) {
    public Category toModel(){
        return new Category(name);
    }
}