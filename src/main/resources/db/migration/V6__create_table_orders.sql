CREATE TABLE `orders`
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    email      VARCHAR(255)   NOT NULL,
    name       VARCHAR(255)   NOT NULL,
    last_name  VARCHAR(255)   NOT NULL,
    document   VARCHAR(255)   NOT NULL,
    address    VARCHAR(255)   NOT NULL,
    complement VARCHAR(255),
    country_id BIGINT         NOT NULL,
    state_id   BIGINT         NULL,
    city       VARCHAR(255)   NOT NULL,
    cep        VARCHAR(255)   NOT NULL,
    phone      VARCHAR(255)   NOT NULL,
    total      DECIMAL(10, 2) NOT NULL,
    created_at DATETIME       NOT NULL,
    CONSTRAINT fk_orders_country
        FOREIGN KEY (country_id)
            REFERENCES country (id),
    CONSTRAINT fk_orders_state
        FOREIGN KEY (state_id)
            REFERENCES state (id)
            ON DELETE SET NULL -- Obs: Coloquei porque se o estado for deletado, a referência na order será NULL em vez de quebrar a integridade referencial.
)