package vinelouzada.cdc.country;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country save(Country country) {
        if (countryRepository.existsByName(country.getName())) throw new IllegalArgumentException("Country name already exists");
        return countryRepository.save(country);
    }

    public Country getById(Long countryId) {
        return countryRepository.findById(countryId).orElseThrow(() -> new EntityNotFoundException("Country not found"));
    }
}
