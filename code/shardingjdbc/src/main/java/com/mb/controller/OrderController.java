package com.mb.controller;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.mb.bean.Order;
import com.mb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping("/add")
    public String add(){
        Order order = new Order();
        order.setUserId(1L);
        order.setOrderId(idGenerator.generateId().longValue());
        repository.save(order);
        return "success";
    }

    @RequestMapping("/query")
    public List<Order> queryAll(){
        List<Order> orders = (List<Order>) repository.findAll();
        return orders;
    }

    @RequestMapping("/query/cnt")
    public long queryAllCnt(){
        long cnt = repository.count();
        return cnt;
    }

    @RequestMapping("/add-test")
    public String add2(){
        Order order = new Order();
        Long orderId = idGenerator.generateId().longValue();
        int shift = new Random().nextInt(2);
        order.setUserId(1L * 10000001 + shift);
        orderId += shift;
        order.setOrderId(orderId);
        repository.save(order);
        return "success";
    }
}
