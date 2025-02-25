package vinelouzada.cdc.book;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.author.AuthorService;
import vinelouzada.cdc.book.dto.CreateBookRequest;
import vinelouzada.cdc.book.dto.CreateBookResponse;
import vinelouzada.cdc.category.CategoryService;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookController(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Transactional
    @RequestMapping("/create")
    public ResponseEntity<CreateBookResponse> create(@RequestBody @Valid CreateBookRequest request) {
        Book book = bookService.save(request.toModel(authorService, categoryService));
        return ResponseEntity.ok().body(new CreateBookResponse(book));
    }
}
