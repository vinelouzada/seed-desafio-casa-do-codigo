package vinelouzada.cdc.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record ShoppingCartDTO(
        @NotNull
        @Positive
        BigDecimal total,
        @Valid
        @Size(min = 1)
        List<ItemDTO> items
) {
}
