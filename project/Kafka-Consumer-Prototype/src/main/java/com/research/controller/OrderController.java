package com.research.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.dto.OrderDto;
import com.research.service.OrderService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author majid
 *
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/order")
@Slf4j
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/getAll")
	public ResponseEntity<OrderDto> getAll() {
		List<OrderDto> allOrder = orderService.getAllOrder();
		return new ResponseEntity(allOrder, HttpStatus.OK);
	}
}
