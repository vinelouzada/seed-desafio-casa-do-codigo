CREATE TABLE coupon
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    code          VARCHAR(255) NOT NULL UNIQUE,
    discount      INT          NOT NULL,
    expiration_at DATETIME     NOT NULL,
    created_at    DATETIME     NOT NULL
)