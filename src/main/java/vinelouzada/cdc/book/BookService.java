package vinelouzada.cdc.book;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        if (bookRepository.existsBookByTitleOrIsbn(book.getTitle(), book.getIsbn())) throw new IllegalArgumentException();

        return bookRepository.save(book);
    }
}
