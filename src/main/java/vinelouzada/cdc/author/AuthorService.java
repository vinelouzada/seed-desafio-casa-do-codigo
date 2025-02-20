package vinelouzada.cdc.author;

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
}
