package com.mb;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.mb.bean.Order;
import com.mb.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private OrderRepository repository;


    @org.junit.Test
    public void testGenId(){
        int cnt = 10;
        System.out.println("=====");
        for(int i=0;i<cnt;i++) {
            Long id = idGenerator.generateId().longValue();
            System.out.println(id);
        }
        System.out.println("=====");
    }

    /**
     * 发现IdGenerator高并发执行基本都是偶数
     * 再采用随机数处理下，确保奇数/偶数都有
     */
    @org.junit.Test
    public void testAdd(){
        Order order = new Order();
        int cnt = 10;
        System.out.println("====");
        for(int i = 0; i < cnt; i++) {
            order.setUserId(1L * i);
            Long orderId = idGenerator.generateId().longValue();
            int shift = new Random().nextInt(2);
            orderId += shift;
            order.setOrderId(orderId);
            repository.save(order);
            System.out.println(order);
        }
        System.out.println("====");
    }

    @org.junit.Test
    public void testCnt(){
        Long startTime = System.currentTimeMillis();    //获取开始时间
//        List<Order> orderList = (List<Order>)repository.findAll();
        long cnt = repository.count();
        long endTime = System.currentTimeMillis();    //获取结束时间
//        long cnt = orderList.size();
        System.out.println("==============");
        System.out.println(cnt);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }


    @org.junit.Test
    public void testAddOne(){
        Order order = new Order();
        order.setUserId(1L * 10000001);
        Long orderId = idGenerator.generateId().longValue();
        int shift = new Random().nextInt(2);
        orderId += shift;
        order.setOrderId(orderId);

        Long startTime = System.currentTimeMillis();    //获取开始时间
        Order order1 = repository.save(order);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("==============");
        System.out.println(order1);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }
}
