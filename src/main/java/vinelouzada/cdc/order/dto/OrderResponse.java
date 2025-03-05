package vinelouzada.cdc.order.dto;

import vinelouzada.cdc.country.Country;
import vinelouzada.cdc.order.Item;
import vinelouzada.cdc.order.Order;
import vinelouzada.cdc.state.State;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        String email,
        String name,
        String lastName,
        String document,
        String address,
        String complement,
        String city,
        Country country,
        State state,
        String cep,
        String phone,
        List<Item> items,
        String createdAt
) {

    public OrderResponse(Order order){
        this(order.getId(), order.getEmail(), order.getName(), order.getLastName(),
                order.getDocument(), order.getAddress(), order.getComplement(), order.getCity(),
                order.getCountry(), order.getState(), order.getCep(), order.getPhone(), order.getItems(), order.getCreatedAtFormatted());
    }
}
