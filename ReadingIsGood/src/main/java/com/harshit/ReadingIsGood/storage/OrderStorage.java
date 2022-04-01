package com.harshit.ReadingIsGood.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.harshit.ReadingIsGood.entity.Order;

@Component
public class OrderStorage {
	
	Map<Integer, Order> orders;
	
	Map<Integer,List<Integer>> customerOrders;
	
	public OrderStorage() {
		super();
		this.orders = new HashMap<>();
		this.customerOrders = new HashMap<>();
	}

	public void addOrder(Order order)
	{
		int orderId = order.getId();
		int customerId = order.getCustomerId();
		orders.put(orderId, order);
		
		addOrder(customerId,orderId);
	}
	
	private void addOrder(int customerId, int orderId)
	{
		if(customerOrders.containsKey(customerId))
		{
			List<Integer> customerOrder = customerOrders.get(customerId);
			customerOrder.add(orderId);
			customerOrders.put(customerId, customerOrder);
		}
		else
		{
			List<Integer> customerOrder = new ArrayList<>();
			customerOrder.add(orderId);
			customerOrders.put(customerId, customerOrder);
		}
	}
	
	public List<Order> getAllOrdersForCustomer(int customerId) {
		List<Order> orderList = new ArrayList<>();

		if (customerOrders.containsKey(customerId))

		{
			List<Integer> orderIds = customerOrders.get(customerId);
			System.out.println(orderIds);

			for (Integer orderId : orderIds) {
				orderList.add(orders.get(orderId));
			}
		}

		return orderList;
	}
	
	public Order getOrder(int orderId)
	{
		if(orders.containsKey(orderId))
			return orders.get(orderId);
		else
		{
			// handle this case as per requirement
			// returning null to keep things simple
			return null;
		}
	}

}
