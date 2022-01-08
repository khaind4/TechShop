package com.khaind4.springboot.techshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin
    @PostMapping
    public boolean add(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @CrossOrigin
    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer) {
        return customerService.login(customer);
    }

    @CrossOrigin
    @GetMapping("/")
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Customer get(@PathVariable long id){
        return customerService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Customer update(@PathVariable long id, @RequestBody Customer customer) {
        return customerService.update(id,customer);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public List<Customer> delete(@PathVariable long id){
        return customerService.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public void deleteAll(){
        customerService.deleteAll();
    }

}
