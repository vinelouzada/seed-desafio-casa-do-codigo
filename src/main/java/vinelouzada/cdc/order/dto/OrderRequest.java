package vinelouzada.cdc.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
        @Valid @NotNull CustomerDTO customer,
        @Valid @NotNull ShoppingCartDTO cart
) {
}
