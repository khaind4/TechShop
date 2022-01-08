package com.khaind4.springboot.techshop.orderDetail;

import com.khaind4.springboot.techshop.order1.Order1;
import com.khaind4.springboot.techshop.product.Product;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long odid;

    @Column
    private int quantity;

    @OneToOne
    private Product product;

    @Column
    private double odPrice;


    // Constructor

    public OrderDetail() {
    }


    // Getter

    public long getOdid() {
        return odid;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getOdPrice() {
        return odPrice;
    }


// Setter

    public void setOdid(long odid) {
        this.odid = odid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOdPrice(double odPrice) {
        this.odPrice = odPrice;
    }
}
