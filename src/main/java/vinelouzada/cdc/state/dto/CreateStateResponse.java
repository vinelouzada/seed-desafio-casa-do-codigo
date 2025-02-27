package vinelouzada.cdc.state.dto;

import vinelouzada.cdc.state.State;

public record CreateStateResponse(
        Long id,
        String name,
        Long countryId
) {
    public CreateStateResponse (State state) {
       this(state.getId(), state.getName(), state.getCountryId());
    }
}
