package com.khaind4.springboot.techshop.product;

import java.util.List;

public interface ProductService {
    public Product save(Product product);
    public Product findById(long id);
    public List<Product> findAll();
    public Product update(long id, Product product);
    public List<Product> sort(String category, String attr, boolean asc);
    public List<Product> findByCategory(String category);
    public List<Product> search(String s);
    public List<Product> deleteById(long id);
    public void deleteAll();
}
