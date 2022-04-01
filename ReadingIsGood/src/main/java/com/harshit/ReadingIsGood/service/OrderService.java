package com.harshit.ReadingIsGood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.ReadingIsGood.entity.Order;
import com.harshit.ReadingIsGood.exception.ItemOutOfStockException;
import com.harshit.ReadingIsGood.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrdersForCustomer(int customerId)
	{
		return orderRepository.getAllOrdersForCustomer(customerId);
	}
	
	public void buyBook(int customerId, int bookId, int copies) throws ItemOutOfStockException
	{
		orderRepository.buyBook(customerId, bookId, copies);
	}
	
	public Order getOrder(int orderId)
	{
		return orderRepository.getOrder(orderId);
	}

}
