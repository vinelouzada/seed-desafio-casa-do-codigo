package vinelouzada.cdc.order;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.book.BookService;
import vinelouzada.cdc.country.CountryService;
import vinelouzada.cdc.order.dto.OrderRequest;
import vinelouzada.cdc.order.dto.OrderResponse;
import vinelouzada.cdc.state.StateService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final StateService stateService;
    private final CountryService countryService;
    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderController(StateService stateService, CountryService countryService, BookService bookService, OrderRepository orderRepository) {
        this.stateService = stateService;
        this.countryService = countryService;
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid OrderRequest orderRequest) {
        Order order = orderRequest.toOrder(stateService, countryService, bookService);
        orderRepository.save(order);

        return ResponseEntity.ok().body(new OrderResponse(order));
    }
}
