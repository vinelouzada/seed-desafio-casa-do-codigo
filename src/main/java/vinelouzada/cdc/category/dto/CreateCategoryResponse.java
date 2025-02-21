package vinelouzada.cdc.category.dto;

import vinelouzada.cdc.category.Category;
import java.time.LocalDateTime;

public record CreateCategoryResponse(Long id, String name, LocalDateTime createdAt) {
    public CreateCategoryResponse(Category category){
        this(category.getId(), category.getName(), category.getCreatedAt());
    }
}