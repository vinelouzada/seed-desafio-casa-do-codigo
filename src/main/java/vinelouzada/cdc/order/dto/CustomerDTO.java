package vinelouzada.cdc.order.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vinelouzada.cdc.shared.Document;

public record CustomerDTO(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String name,
        @NotBlank
        String lastName,
        @NotBlank
        @Document
        String document,
        @NotBlank
        String address,
        @NotBlank
        String complement,
        @NotBlank
        String city,
        @NotNull
        Long countryId,
        @NotNull
        Long stateId,
        @NotBlank
        String cep,
        @NotBlank
        String phone
) {
}
