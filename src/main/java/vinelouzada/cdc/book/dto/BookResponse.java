package vinelouzada.cdc.book.dto;

import vinelouzada.cdc.author.dto.AuthorNameAndDescriptionDTO;
import vinelouzada.cdc.book.Book;
import vinelouzada.cdc.category.dto.CategoryNameDTO;

import java.math.BigDecimal;

public record BookResponse(
        Long id,
        String title,
        String summary,
        String tableOfContents,
        BigDecimal price,
        int numberOfPages,
        String isbn,
        String publishedAt,
        AuthorNameAndDescriptionDTO author,
        CategoryNameDTO category
) {

    public BookResponse(Book book){
        this(book.getId(), book.getTitle(), book.getSummary(), book.getTableOfContents(),
                book.getPrice(), book.getNumberOfPages(), book.getIsbn(), book.getPublishedAtFormatted(),
                new AuthorNameAndDescriptionDTO(book.getAuthor()),
                new CategoryNameDTO(book.getCategory())
        );
    }
}
