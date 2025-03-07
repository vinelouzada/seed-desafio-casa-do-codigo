package vinelouzada.cdc.coupon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    boolean existsByCode(String code);
}
