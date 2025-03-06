package vinelouzada.cdc.coupon.dto;

import jakarta.validation.constraints.*;
import vinelouzada.cdc.coupon.Coupon;
import vinelouzada.cdc.shared.UniqueValue;

import java.time.LocalDateTime;

public record CreateCouponRequest(
        @NotBlank
        @UniqueValue(field = "code", domainClass = Coupon.class)
        String code,
        @NotNull
        @Positive
        int discountPercentage,
        @Future
        LocalDateTime expirationAt
) {
    public Coupon toModel() {
        return new Coupon(code, expirationAt, discountPercentage);
    }
}
