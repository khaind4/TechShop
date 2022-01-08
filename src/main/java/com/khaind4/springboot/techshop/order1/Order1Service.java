package com.khaind4.springboot.techshop.order1;

import java.util.List;

public interface Order1Service {
    public Order1 save(Order1 order1);
    public List<Order1> findAll();
    public Order1 findById(long id);
    public List<Order1> findByCustomerId(long id);
    public Order1 update(long id, Order1 order1);
    public List<Order1> deleteById(long id);
    public void deleteAll();
}
