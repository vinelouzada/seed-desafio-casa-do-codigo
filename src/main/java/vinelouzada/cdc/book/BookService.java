package vinelouzada.cdc.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        if (bookRepository.existsBookByTitleOrIsbn(book.getTitle(), book.getIsbn())) throw new IllegalArgumentException();

        return bookRepository.save(book);
    }
}
