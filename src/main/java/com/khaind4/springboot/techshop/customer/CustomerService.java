package com.khaind4.springboot.techshop.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    public boolean save(Customer customer);
    public Customer login(Customer customer);
    public Customer findById(long id);
    public List<Customer> findAll();
    public Customer update(long id, Customer customer);
    public List<Customer> deleteById(long id);
    public void deleteAll();
}
