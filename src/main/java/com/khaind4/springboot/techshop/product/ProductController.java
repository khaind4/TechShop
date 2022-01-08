package com.khaind4.springboot.techshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return productService.findById(id);
    }

    @CrossOrigin
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Product update(@PathVariable long id, @RequestBody Product product) {
        return productService.update(id,product);
    }

    @CrossOrigin
    @GetMapping("/category/{category}")
    public List<Product> findByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }

    @CrossOrigin
    @GetMapping("/search")
    public List<Product> search(@RequestParam String s) {
        return productService.search(s);
    }

    @CrossOrigin
    @GetMapping("/sort")
    public List<Product> sort(@RequestParam String category, @RequestParam String attr, @RequestParam boolean asc) {
        System.out.println(category);
        System.out.println(attr);
        System.out.println(asc);
        return productService.sort(category,attr,asc);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public List<Product> deleteById(@PathVariable long id) {
        return productService.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public void deteleAll() {
        productService.deleteAll();
    }
}
