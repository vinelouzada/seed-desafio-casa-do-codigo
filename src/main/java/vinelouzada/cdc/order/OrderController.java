package vinelouzada.cdc.order;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.order.dto.OrderRequest;
import vinelouzada.cdc.state.StateRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final StateRepository stateRepository;

    public OrderController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid OrderRequest orderRequest) {
        if (!stateRepository.existsByIdAndCountry_Id(orderRequest.customer().stateId(), orderRequest.customer().countryId()))
            throw new IllegalArgumentException("Invalid state");

        return ResponseEntity.ok().body(orderRequest);
    }
}
