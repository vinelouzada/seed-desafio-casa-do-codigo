package vinelouzada.cdc.book.dto;

import jakarta.validation.constraints.*;
import vinelouzada.cdc.author.Author;
import vinelouzada.cdc.author.AuthorService;
import vinelouzada.cdc.book.Book;
import vinelouzada.cdc.category.Category;
import vinelouzada.cdc.category.CategoryService;
import vinelouzada.cdc.shared.UniqueValue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateBookRequest(
        @NotBlank
        @UniqueValue(field = "title", domainClass = Book.class)
        String title,

        @NotBlank
        @Size(max = 500)
        String summary,

        @NotBlank
        String tableOfContents,

        @NotNull
        @DecimalMin(value = "20")
        BigDecimal price,

        @Positive
        @NotNull
        @Min(value = 100)
        int numberOfPages,

        @NotBlank
        @UniqueValue(field = "isbn", domainClass = Book.class)
        String isbn,

        @Future
        LocalDateTime publishedAt,

        @NotNull
        Long categoryId,

        @NotNull
        Long authorId
) {
    public Book toModel(AuthorService authorService, CategoryService categoryService) {
        Author author = authorService.getAuthor(authorId);
        Category category = categoryService.getCategory(categoryId);

        return new Book(title, summary, tableOfContents, price, numberOfPages, isbn, publishedAt, author, category);
    }
}
