package vinelouzada.cdc.author.dto;

import vinelouzada.cdc.author.Author;

import java.time.LocalDateTime;

public record CreateAuthorResponse(
        Long id,
        String name,
        String email,
        String description,
        LocalDateTime createdAt
) {
    public CreateAuthorResponse (Author author) {
        this(author.getId(), author.getName(), author.getEmail(), author.getDescription(), LocalDateTime.now());
    }
}
