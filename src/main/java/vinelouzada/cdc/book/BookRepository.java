package vinelouzada.cdc.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsBookByTitleOrIsbn(String title, String isbn);
}
