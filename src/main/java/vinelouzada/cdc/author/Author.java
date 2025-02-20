package vinelouzada.cdc.author;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String description;
    private LocalDateTime createdAt;

    @Deprecated
    public Author(){}

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getDescription() { return description; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
