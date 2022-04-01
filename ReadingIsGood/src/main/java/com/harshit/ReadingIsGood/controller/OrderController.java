package com.harshit.ReadingIsGood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.ReadingIsGood.entity.Order;
import com.harshit.ReadingIsGood.exception.ItemOutOfStockException;
import com.harshit.ReadingIsGood.model.ResponseModel;
import com.harshit.ReadingIsGood.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseModel buyBook(@RequestParam int customerId, @RequestParam int bookId, @RequestParam int copies)
	{
		try
		{
			orderService.buyBook(customerId, bookId, copies);
			return new ResponseModel(HttpStatus.OK,"Order placed successfully");
		}
		catch(ItemOutOfStockException ex)
		{
			ex.printStackTrace();
			return new ResponseModel(HttpStatus.NOT_FOUND,ex.getMessage());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
		}
		
	}
	
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable int id)
	{
		return orderService.getOrder(id);
	}

}
