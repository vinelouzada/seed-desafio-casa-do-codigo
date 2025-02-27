package vinelouzada.cdc.country.dto;

import vinelouzada.cdc.country.Country;

public record CreateCountryResponse(Long id, String name) {
    public CreateCountryResponse(Country country){
        this(country.getId(), country.getName());
    }
}
