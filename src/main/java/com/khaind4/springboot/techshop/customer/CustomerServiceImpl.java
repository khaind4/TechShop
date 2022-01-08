package com.khaind4.springboot.techshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean save(Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer c : customers) {
            if(c.getEmail().equalsIgnoreCase(customer.getEmail())) return false;
        }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer login(Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer c : customers) {
            if(c.getEmail().equalsIgnoreCase(customer.getEmail())) {
                if(c.getPassword().equalsIgnoreCase(customer.getPassword())) return c;
            }
        }
        return null;
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(long id, Customer customer) {
        Customer customer1 = customerRepository.findById(id).orElse(null);

        customer1.setName(customer.getName());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setAddress(customer.getAddress());

        return customerRepository.save(customer1);
    }

    @Override
    public List<Customer> deleteById(long id) {
        customerRepository.deleteById(id);
        return customerRepository.findAll();
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
