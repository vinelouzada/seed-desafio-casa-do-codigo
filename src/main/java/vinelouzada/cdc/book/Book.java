package vinelouzada.cdc.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;
import vinelouzada.cdc.author.Author;
import vinelouzada.cdc.category.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;
    private String tableOfContents;
    private BigDecimal price;
    private int numberOfPages;
    private String isbn;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;

    @OneToOne
    private Category category;

    @OneToOne
    private Author author;

    @Deprecated
    public Book() {}

    public Book(@NotBlank String title, @NotBlank @Size(max = 500) String summary, @NotBlank String tableOfContents,
                @NotNull @DecimalMin(value = "20") BigDecimal price, @Positive @NotNull @Min(value = 100) int numberOfPages,
                @NotBlank String isbn, @Future LocalDateTime publishedAt, @NotNull Author author, @NotNull Category category) {
        Assert.hasText(title, "Title cannot be empty or blank");
        Assert.hasText(summary, "Summary cannot be empty or blank");
        Assert.isTrue(summary.length() <= 500, "Summary length exceeds 500");
        Assert.hasText(tableOfContents, "Table of contents cannot be empty or blank");
        Assert.notNull(price, "Price cannot be null");
        Assert.isTrue(price.compareTo(BigDecimal.valueOf(20)) >= 0, "Price must be greater than or equal to twenty");
        Assert.isTrue(numberOfPages >= 100, "Number of pages must be greater or equal than 100");
        Assert.hasText(isbn, "ISBN cannot be empty or blank");
        Assert.notNull(publishedAt, "Published at cannot be null");
        Assert.isTrue(publishedAt.isAfter(LocalDateTime.now()), "Published At must be after now");
        Assert.notNull(author, "Author cannot be null");
        Assert.notNull(category, "Category cannot be null");

        this.title = title;
        this.summary = summary;
        this.tableOfContents = tableOfContents;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publishedAt = publishedAt;
        this.author = author;
        this.category = category;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getCategoryId() {
        return category.getId();
    }

    public Long getAuthorId() {
        return author.getId();
    }
}
