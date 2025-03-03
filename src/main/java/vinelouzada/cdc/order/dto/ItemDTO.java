package vinelouzada.cdc.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import vinelouzada.cdc.book.Book;
import vinelouzada.cdc.shared.ExistsBy;

public record ItemDTO(
        @NotNull
        @ExistsBy(field = "id", domainClass = Book.class)
        Long id,
        @NotNull
        @Positive
        int quantity
) {
}
