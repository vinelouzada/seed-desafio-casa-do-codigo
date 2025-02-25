CREATE TABLE book
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) UNIQUE NOT NULL,
    summary TEXT NOT NULL,
    table_of_contents TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    number_of_pages INT NOT NULL,
    isbn VARCHAR(255) UNIQUE NOT NULL,
    published_at DATETIME NOT NULL,
    created_at DATETIME NOT NULL,
    category_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    CONSTRAINT fk_book_author
        FOREIGN KEY (author_id)
            REFERENCES author (id),
    CONSTRAINT fk_book_category
        FOREIGN KEY (category_id)
            REFERENCES category (id)
);