package com.mb.repository;

import com.mb.bean.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order,Long> {

}