package com.khaind4.springboot.techshop.order1;

import com.khaind4.springboot.techshop.customer.Customer;
import com.khaind4.springboot.techshop.orderDetail.OrderDetail;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oid;

    @Column
    private Date date = new Date();

    @Column
    private double totalPrice;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail = new ArrayList<>();

    // Constructor

    public Order1() {
    }


    // Getter

    public long getOid() {
        return oid;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }


    // Setter

    public void setOid(long oid) {
        this.oid = oid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
