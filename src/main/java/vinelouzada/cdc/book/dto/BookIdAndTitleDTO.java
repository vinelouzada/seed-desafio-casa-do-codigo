package vinelouzada.cdc.book.dto;

import vinelouzada.cdc.book.Book;

public record BookIdAndTitleDTO(Long id, String title) {
    public BookIdAndTitleDTO(Book book){
        this(book.getId(), book.getTitle());
    }
}
