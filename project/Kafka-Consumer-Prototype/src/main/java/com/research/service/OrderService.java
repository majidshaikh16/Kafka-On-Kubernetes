package com.research.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.research.dto.OrderDto;
import com.research.entity.Order;
import com.research.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author majid
 *
 */
@Slf4j
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public void createNewOrder(byte[] order, String messageKey) {
		ObjectMapper mapper = new ObjectMapper();
		Order orderEntity = null;
		try {
			log.info("Consumed new order with key {}, order details {}", messageKey, order);
			orderEntity = mapper.readValue(order, Order.class);
			orderRepository.save(orderEntity);
			log.info("Order create with order details {}", orderEntity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<OrderDto> getAllOrder() {
		ObjectMapper mapper = new ObjectMapper();
		List<Order> allOrders = (List<Order>) orderRepository.findAll();
		return mapper.convertValue(allOrders, List.class);
	}
}
