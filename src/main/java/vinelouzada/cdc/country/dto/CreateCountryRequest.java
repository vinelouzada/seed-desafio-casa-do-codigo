package vinelouzada.cdc.country.dto;

import jakarta.validation.constraints.NotBlank;
import vinelouzada.cdc.country.Country;
import vinelouzada.cdc.shared.UniqueValue;

public record CreateCountryRequest(
        @NotBlank
        @UniqueValue(field = "name", domainClass = Country.class)
        String name
) {
    public Country toModel() {
        return new Country(name);
    }
}
