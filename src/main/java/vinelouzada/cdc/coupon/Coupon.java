package vinelouzada.cdc.coupon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private int discount;
    private LocalDateTime expirationAt;
    private LocalDateTime createdAt;

    @Deprecated
    public Coupon() {}

    public Coupon(String code, @Future LocalDateTime expirationAt, @Positive int discount) {
        this.code = code;
        this.expirationAt = expirationAt;
        this.discount = discount;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getDiscount() {
        return discount;
    }

    public BigDecimal getDiscountAsPercentage() {
        return BigDecimal.valueOf(discount).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public LocalDateTime getExpirationAt() {
        return expirationAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", expirationAt=" + expirationAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
