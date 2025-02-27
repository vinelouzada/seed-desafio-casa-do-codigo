package vinelouzada.cdc.state;

import jakarta.persistence.*;
import vinelouzada.cdc.country.Country;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Country country;

    @Deprecated
    public State() {}

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Long getCountryId() {
        return country.getId();
    }
}
