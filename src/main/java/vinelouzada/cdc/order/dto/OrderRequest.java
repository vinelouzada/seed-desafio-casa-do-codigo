package vinelouzada.cdc.order.dto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import vinelouzada.cdc.book.Book;
import vinelouzada.cdc.book.BookService;
import vinelouzada.cdc.country.Country;
import vinelouzada.cdc.country.CountryService;
import vinelouzada.cdc.order.Item;
import vinelouzada.cdc.order.Order;
import vinelouzada.cdc.state.State;
import vinelouzada.cdc.state.StateService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record OrderRequest(
        @Valid @NotNull CustomerDTO customer,
        @Valid @NotNull ShoppingCartDTO cart
) {
    public Order toOrder(StateService stateService, CountryService countryService, BookService bookService) {
        State state = stateService.getById(customer.stateId());
        Country country = countryService.getById(customer.countryId());

        if (!state.belongsToCountry(country))
            throw new IllegalArgumentException("State: %s does not belong to country: %s".formatted(state.getName(), country.getName()));

        return new Order(customer.email(), customer.name(), customer.lastName(),
                customer.document(), customer.address(), customer.complement(), country, state,
                customer.city(), customer.cep(), customer.phone(), cart.total(), toItems(bookService)
        );
    }

    // A gente passa uma Order e sai uma Lista de Item
    public Function<Order, List<Item>> toItems(BookService bookService) {
        //buscar todos os ID
        List<Book> books = bookService.getBooksByIds(cart.items().stream()
                .map(ItemDTO::id)
                .collect(Collectors.toList()));

        //relaciona book com quantidade
        Map<Book, Integer> bookAndQuantity = cart.items().stream()
                .collect(Collectors.toMap(
                        item -> books.stream()
                                .filter(book -> book.getId().equals(item.id()))
                                .findFirst()
                                .orElseThrow(() -> new EntityNotFoundException("Book not found")),
                        ItemDTO::quantity
                ));

        //cria novo item
        return (order) -> {
            return bookAndQuantity.entrySet().stream()
                    .map(x -> new Item(x.getKey(), x.getKey().getPrice(), x.getValue(), order))
                    .collect(Collectors.toList());
        };
    }
}
