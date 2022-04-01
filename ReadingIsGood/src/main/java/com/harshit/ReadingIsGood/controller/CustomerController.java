package com.harshit.ReadingIsGood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.ReadingIsGood.entity.Customer;
import com.harshit.ReadingIsGood.entity.Order;
import com.harshit.ReadingIsGood.exception.DuplicateRegisteryException;
import com.harshit.ReadingIsGood.model.ResponseModel;
import com.harshit.ReadingIsGood.service.CustomerService;
import com.harshit.ReadingIsGood.service.OrderService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}



	@PostMapping("/customer/register")
	public ResponseModel registerCustomer(@RequestBody Customer customer)
	{
		try
		{
			customerService.registerCustomer(customer);
			return new ResponseModel(HttpStatus.OK, "Successfully registered");
		}
		catch(DuplicateRegisteryException ex)
		{
			ex.printStackTrace();
			return new ResponseModel(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
	
	@GetMapping("/customer/orders/{customerId}")
	public List<Order> getAllOrders(@PathVariable int customerId)
	{
		return orderService.getAllOrdersForCustomer(customerId);
	}

}
