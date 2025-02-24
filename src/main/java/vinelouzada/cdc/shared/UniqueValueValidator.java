package vinelouzada.cdc.shared;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    private final EntityManager entityManager;
    private String field;
    private Class<?> domainClass;

    public UniqueValueValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.domainClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String sql = String.format("""
                                SELECT 1
                                    FROM %s
                                WHERE %s = :value
                """, domainClass.getSimpleName(), field);
        Query query = entityManager.createQuery(sql);
        query.setParameter("value", value);

        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
