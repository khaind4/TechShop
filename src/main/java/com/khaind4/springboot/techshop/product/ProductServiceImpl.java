package com.khaind4.springboot.techshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(long id, Product product) {
        Product product1 = productRepository.findById(id).orElse(null);

        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setBrand(product.getBrand());
        product1.setCategory(product.getCategory());
        product1.setImage(product.getImage());

        return productRepository.save(product1);
    }

    @Override
    public List<Product> sort(String category, String attr, boolean asc) {
        List<Product> sortList = new ArrayList<>();
        if(asc==true) {
            List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.ASC, attr));
            for(Product p : products) {
                if(p.getCategory().equalsIgnoreCase(category)) sortList.add(p);
            }
        } else {
            List<Product> products = productRepository.findAll(Sort.by(Sort.Direction.DESC, attr));
            for(Product p : products) {
                if(p.getCategory().equalsIgnoreCase(category)) sortList.add(p);
            }
        }
        return sortList;
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> products = productRepository.findAll();
        List<Product> categoryProducts = new ArrayList<>();
        for(Product product : products) {
            if(product.getCategory().equals(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    @Override
    public List<Product> search(String s) {
        List<Product> products = productRepository.findAll();
        List<Product> searchProducts = new ArrayList<>();
        for(Product product: products) {
            if(product.getName().toLowerCase().contains(s.toLowerCase())) {
                searchProducts.add(product);
            }
        }
        return searchProducts;
    }

    @Override
    public List<Product> deleteById(long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
