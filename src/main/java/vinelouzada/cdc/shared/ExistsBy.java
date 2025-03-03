package vinelouzada.cdc.shared;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ExistsByValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExistsBy {
    String message() default "This value not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
    Class<?> domainClass();
}
