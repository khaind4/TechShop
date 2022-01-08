package com.khaind4.springboot.techshop.customer;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    @Column
    private String name;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;


    // Constructor

    public Customer() {
    }


    // Getter

    public long getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }


    // Setter

    public void setCid(long cid) {
        this.cid = cid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
