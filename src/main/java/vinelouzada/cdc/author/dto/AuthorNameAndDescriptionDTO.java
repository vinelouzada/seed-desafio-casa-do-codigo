package vinelouzada.cdc.author.dto;

import vinelouzada.cdc.author.Author;

public record AuthorNameAndDescriptionDTO(
        String name,
        String description
) {
   public AuthorNameAndDescriptionDTO(Author author) {
       this(author.getName(), author.getDescription());
   }
}
