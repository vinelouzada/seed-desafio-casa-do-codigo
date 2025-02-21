package vinelouzada.cdc.author;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vinelouzada.cdc.exceptions.EmailAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {

    private AuthorRepository authorRepository;
    private AuthorService authorService;
    private Author author;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        authorService = new AuthorService(authorRepository);
        author = new Author("Vinícius Louzada Valente", "email@example.com", "With great power comes great responsibility");
    }

    @Test
    void save__should_throw_exception_if_email_already_exists() {
        when(authorRepository.existsByEmail(author.getEmail())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> authorService.save(author));
        verify(authorRepository, never()).save(author);
    }

    @Test
    void save__should_save_author_when_email_does_not_exist() {
        when(authorRepository.existsByEmail(author.getEmail())).thenReturn(false);

        assertDoesNotThrow(() -> authorService.save(author));
        verify(authorRepository, times(1)).save(author);
    }
}