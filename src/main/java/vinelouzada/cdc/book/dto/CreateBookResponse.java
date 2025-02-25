package vinelouzada.cdc.book.dto;

import vinelouzada.cdc.book.Book;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateBookResponse(
        Long id,
        String title,
        String summary,
        String tableOfContents,
        BigDecimal price,
        int numberOfPages,
        String isbn,
        LocalDateTime publishedAt,
        LocalDateTime createdAt,
        Long authorId,
        Long categoryId
) {
    public CreateBookResponse (Book book) {
        this(book.getId(), book.getTitle(), book.getSummary(), book.getTableOfContents(), book.getPrice(), book.getNumberOfPages(),
                book.getIsbn(), book.getPublishedAt(), book.getCreatedAt(), book.getAuthorId(), book.getCategoryId());
    }
}
