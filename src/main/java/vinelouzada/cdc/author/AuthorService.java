package vinelouzada.cdc.author;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import vinelouzada.cdc.exceptions.EmailAlreadyExistsException;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        if (authorRepository.existsByEmail(author.getEmail())) throw new EmailAlreadyExistsException();

        return authorRepository.save(author);
    }

    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("Author not found"));
    }
}
