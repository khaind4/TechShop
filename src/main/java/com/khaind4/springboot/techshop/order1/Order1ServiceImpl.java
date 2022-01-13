package com.khaind4.springboot.techshop.order1;

import com.khaind4.springboot.techshop.exception.NotFoundException;
import com.khaind4.springboot.techshop.orderDetail.OrderDetail;
import com.khaind4.springboot.techshop.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Order1ServiceImpl implements Order1Service{

    @Autowired
    private Order1Repository order1Repository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Order1 save(Order1 order1) {

        // --- set orderDetailPrice & totalPrice ---
        List<OrderDetail> od = order1.getOrderDetail();
        double totalPrice = 0;

        for(OrderDetail od1 : od) {
            // find Product.price
            long pid = od1.getProduct().getPid();
            double price = productRepository.findById(pid)
                    .orElseThrow(() -> new NotFoundException("Not found the ID: " + pid)).getPrice();

            // orderDetailPrice = quantity * price
            double odPrice = od1.getQuantity() * price;
            od1.setOdPrice(odPrice);
            totalPrice += odPrice;
        }
        order1.setTotalPrice(totalPrice);

        return order1Repository.save(order1);
    }

    @Override
    public List<Order1> findAll() {
        return order1Repository.findAll();
    }

    @Override
    public Order1 findById(long id) {
        return order1Repository.findById(id).orElseThrow(() -> new NotFoundException("Not found the ID: " + id));
    }

    @Override
    public List<Order1> findByCustomerId(long id) {
        List<Order1> orders = order1Repository.findAll();
        List<Order1> orders1 = new ArrayList<>();
        for (Order1 o : orders) {
            if(o.getCustomer().getCid()==id) orders1.add(o);
        }
        return orders1;
    }

    @Override
    public Order1 update(long id, Order1 order1) {
        // update orderDetail
        Order1 o = order1Repository.findById(id).orElseThrow(() -> new NotFoundException("Not found the ID: " + id));
        o.setOrderDetail(order1.getOrderDetail());

        // update odPrice & totalPrice
        double totalPrice = 0;
        List<OrderDetail> od = o.getOrderDetail();
        for (OrderDetail od1 : od) {
            // find Product.price
            long pid = od1.getProduct().getPid();
            double price = productRepository.findById(pid)
                    .orElseThrow(() -> new NotFoundException("Not found the ID: " + pid)).getPrice();

            // orderDetailPrice = quantity * price
            double odPrice = od1.getQuantity() * price;
            od1.setOdPrice(odPrice);
            totalPrice += odPrice;
        }
        o.setTotalPrice(totalPrice);

        return order1Repository.save(o);
    }

    @Override
    public List<Order1> deleteById(long id) {
        order1Repository.deleteById(id);
        return order1Repository.findAll();
    }

    @Override
    public void deleteAll() {
    order1Repository.deleteAll();
    }
}
