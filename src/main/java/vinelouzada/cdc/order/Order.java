package vinelouzada.cdc.order;

import jakarta.persistence.*;
import org.springframework.util.Assert;
import vinelouzada.cdc.country.Country;
import vinelouzada.cdc.state.State;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String lastName;
    private String document;
    private String address;
    private String complement;

    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;
    private String city;
    private String cep;
    private String phone;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    private BigDecimal total;

    private LocalDateTime createdAt;

    @Deprecated
    public Order() {
    }

    public Order(String email, String name, String lastName, String document, String address, String complement,
                 Country country, State state, String city, String cep, String phone, BigDecimal total, Function<Order, List<Item>> itemsFunction) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.country = country;
        this.state = state;
        this.city = city;
        this.cep = cep;
        this.phone = phone;
        this.items = itemsFunction.apply(this);
        this.total = total;
        Assert.isTrue(totalPriceEquals(), "Total price should be equal to totalPrice");
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCep() {
        return cep;
    }

    public String getPhone() {
        return phone;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getCreatedAtFormatted() {
        return createdAt.format( DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public boolean totalPriceEquals(){
        return total.equals(calculateTotalPriceFromItems());
    }

    private BigDecimal calculateTotalPriceFromItems(){
        return items.stream().map(Item::getTotal).reduce(BigDecimal.ZERO, java.math.BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", country=" + country +
                ", state=" + state +
                ", city='" + city + '\'' +
                ", cep='" + cep + '\'' +
                ", phone='" + phone + '\'' +
                ", items=" + items +
                ", total=" + total +
                ", createdAt=" + createdAt +
                '}';
    }
}