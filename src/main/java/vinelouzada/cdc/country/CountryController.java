package vinelouzada.cdc.country;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.country.dto.CreateCountryRequest;
import vinelouzada.cdc.country.dto.CreateCountryResponse;

@RestController
@RequestMapping("/country")
public class CountryController {

    public final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCountryResponse> create(@RequestBody @Valid CreateCountryRequest request) {
        Country country = countryService.save(request.toModel());
        return ResponseEntity.ok(new CreateCountryResponse(country));
    }

}
