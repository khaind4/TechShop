package com.khaind4.springboot.techshop.order1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order1")
public class Order1Controller {

    @Autowired
    private Order1Service order1Service;

    @CrossOrigin
    @PostMapping
    private Order1 save(@RequestBody Order1 order1) {
        return order1Service.save(order1);
    }

    @CrossOrigin
    @GetMapping
    private List<Order1> findAll() {
        return order1Service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private Order1 findById(@PathVariable long id) {
        return order1Service.findById(id);
    }

    @CrossOrigin
    @GetMapping("/customer/{id}")
    private List<Order1> findByCustomerId(@PathVariable long id) {
        return order1Service.findByCustomerId(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private Order1 update(@PathVariable long id, @RequestBody Order1 order1) {
        return order1Service.update(id,order1);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private List<Order1> deleteById(@PathVariable long id) {
        return order1Service.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    private void deleteAll() {
        order1Service.deleteAll();
    }
}
