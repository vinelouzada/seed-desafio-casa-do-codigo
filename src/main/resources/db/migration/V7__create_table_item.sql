CREATE TABLE item
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id  BIGINT         NOT NULL,
    order_id BIGINT         NOT NULL,
    price    DECIMAL(10, 2) NOT NULL,
    quantity INT            NOT NULL,
    CONSTRAINT fk_item_book
        FOREIGN KEY (book_id)
            REFERENCES book (id),
    CONSTRAINT fk_item_order
        FOREIGN KEY (order_id)
            REFERENCES `orders` (id)
);