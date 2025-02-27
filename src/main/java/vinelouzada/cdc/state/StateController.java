package vinelouzada.cdc.state;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.country.CountryService;
import vinelouzada.cdc.state.dto.CreateStateRequest;
import vinelouzada.cdc.state.dto.CreateStateResponse;

@RestController
@RequestMapping("/state")
public class StateController {
    private final StateService stateService;
    private final CountryService countryService;

    public StateController(StateService stateService, CountryService countryService) {
        this.stateService = stateService;
        this.countryService = countryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateStateResponse> create(@RequestBody @Valid CreateStateRequest request) {
        State state = request.toModel(countryService);
        return ResponseEntity.ok().body(new CreateStateResponse(stateService.save(state))) ;
    }
}
