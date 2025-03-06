package vinelouzada.cdc.coupon;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vinelouzada.cdc.coupon.dto.CreateCouponRequest;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/create")
    public ResponseEntity<Coupon> create(@RequestBody @Valid CreateCouponRequest coupon) {
        return new ResponseEntity<>(
                couponService.save(coupon.toModel()),
                HttpStatus.CREATED
        );
    }
}
