package com.research.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.research.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String>{

}
