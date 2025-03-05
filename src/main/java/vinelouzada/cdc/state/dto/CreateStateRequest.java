package vinelouzada.cdc.state.dto;

import jakarta.validation.constraints.NotBlank;
import vinelouzada.cdc.country.Country;
import vinelouzada.cdc.country.CountryService;
import vinelouzada.cdc.shared.UniqueValue;
import vinelouzada.cdc.state.State;


public record CreateStateRequest(
        @NotBlank
        @UniqueValue(field = "name", domainClass = State.class)
        String name,
        Long countryId
) {
    public State toModel(CountryService countryService) {
        Country country = countryService.getById(countryId);
        return new State(name, country);
    }
}
