package vinelouzada.cdc.category.dto;

import vinelouzada.cdc.category.Category;

public record CategoryNameDTO(String name) {
    public CategoryNameDTO(Category category){
        this(category.getName());
    }
}
