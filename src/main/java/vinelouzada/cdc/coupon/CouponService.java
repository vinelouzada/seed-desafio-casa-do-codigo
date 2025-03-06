package vinelouzada.cdc.coupon;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon save(Coupon coupon) {
        Assert.isTrue(LocalDateTime.now().isBefore(coupon.getExpirationAt()), "Coupon expiration date must be in the future");

        if (couponRepository.existsByCode(coupon.getCode()))
            throw new IllegalArgumentException("Coupon code already exists");

        return couponRepository.save(coupon);
    }
}
