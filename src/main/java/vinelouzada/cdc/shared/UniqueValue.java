package vinelouzada.cdc.shared;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "This value already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
    Class<?> domainClass();
}
