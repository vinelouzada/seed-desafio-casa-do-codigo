CREATE TABLE state
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(255) UNIQUE NOT NULL,
    country_id BIGINT              NOT NULL,
    CONSTRAINT fk_state_country
        FOREIGN KEY (country_id)
            REFERENCES country (id)
)