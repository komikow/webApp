package by.komikow.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "basket")
@Data
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private int basketId;

    @Column(name = "basket_set_of_goods")
    private String basketSet;

    @Column(name = "basket_cost")
    private BigDecimal basketCost;

    @Column(name = "basket_fk_customer")
    private int basketFkCustomer;

    public Basket() {
    }

    public Basket(int basketId, String basketSet, BigDecimal basketCost, int basketFkCustomer) {
        this.basketId = basketId;
        this.basketSet = basketSet;
        this.basketCost = basketCost;
        this.basketFkCustomer = basketFkCustomer;
    }
}
