package com.harshit.ReadingIsGood.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harshit.ReadingIsGood.entity.Order;
import com.harshit.ReadingIsGood.exception.ItemOutOfStockException;
import com.harshit.ReadingIsGood.storage.BookStorage;
import com.harshit.ReadingIsGood.storage.OrderStorage;

@Repository
public class OrderRepository {
	
	private static int orderId;
	
	@Autowired
	private OrderStorage orderStorage;
	
	@Autowired
	private BookStorage bookStorage;
	
	public List<Order> getAllOrdersForCustomer(int customerId)
	{
		return orderStorage.getAllOrdersForCustomer(customerId);
	}
	
	private Order createOrder(int customerId, int bookId, int copies)
	{
		return new Order(orderId++, customerId, bookId, copies, LocalDateTime.now());
	}
	
	public void buyBook(int customerId, int bookId, int copies) throws ItemOutOfStockException {
		synchronized (this) {
			int stock = bookStorage.getStock(bookId);
			System.out.println("Stock : "+stock);
			if (stock >= copies) {
				Order order = createOrder(customerId, bookId, copies);
				orderStorage.addOrder(order);
				bookStorage.removeStock(bookId, copies);
			} else {
				throw new ItemOutOfStockException(
						"Not enough item in stock, please try again with lesser number of copies");
			}
		}

	}
	
	public Order getOrder(int id)
	{
		return orderStorage.getOrder(id);
	}
	

}
