package vinelouzada.cdc.author;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.author.dto.CreateAuthorRequest;
import vinelouzada.cdc.author.dto.CreateAuthorResponse;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateAuthorResponse> create(@Valid @RequestBody CreateAuthorRequest request){
        Author author = authorService.save(request.toModel());

        return ResponseEntity.ok(new CreateAuthorResponse(author));
    }
}
