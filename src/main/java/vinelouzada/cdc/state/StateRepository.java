package vinelouzada.cdc.state;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
    boolean existsByName(String name);
}
