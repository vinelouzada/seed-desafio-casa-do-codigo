package vinelouzada.cdc.exceptions;

public class NameAlreadyExistsException extends RuntimeException {
    public NameAlreadyExistsException() {
        super("Name already exists");
    }
}