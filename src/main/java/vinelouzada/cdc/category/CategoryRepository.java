package vinelouzada.cdc.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public boolean existsByName(String name);
}