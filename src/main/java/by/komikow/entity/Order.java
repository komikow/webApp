package by.komikow.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "order_fk_basket")
    private int fkBasket;

    @Column(name = "order_fk_status")
    private int fkStatus;

    public Order() {
    }

    public Order(int orderId, LocalDate orderDate, int fkBasket, int fkStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.fkBasket = fkBasket;
        this.fkStatus = fkStatus;
    }
}
