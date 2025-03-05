    package vinelouzada.cdc.order;

    import jakarta.persistence.*;
    import vinelouzada.cdc.book.Book;

    import java.math.BigDecimal;

    @Entity
    public class Item {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Book book;
        private BigDecimal price;
        private int quantity;

        @ManyToOne
        private Order order;

        @Deprecated
        public Item(){}

        public Item(Book book, BigDecimal price, int quantity, Order order) {
            this.book = book;
            this.price = price;
            this.quantity = quantity;
            this.order = order;
        }

        public BigDecimal getTotal() {
            return price.multiply(BigDecimal.valueOf(quantity));
        }

        public Long getId() {
            return id;
        }

        public Book getBook() {
            return book;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", book=" + book +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", order=" + order +
                    '}';
        }
    }