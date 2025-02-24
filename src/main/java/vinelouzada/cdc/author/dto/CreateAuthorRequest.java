package vinelouzada.cdc.author.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import vinelouzada.cdc.author.Author;
import vinelouzada.cdc.shared.UniqueValue;

public record CreateAuthorRequest(
        @NotBlank
        @Size(max = 255)
        String name,

        @NotBlank
        @Size(max = 255)
        @Email
        @UniqueValue(field = "email", domainClass = Author.class)
        String email,

        @NotBlank
        @Size(max = 400)
        String description
) {
        public Author toModel(){
                return new Author(this.name, this.email, this.description);
        }
}
