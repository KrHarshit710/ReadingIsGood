package com.harshit.ReadingIsGood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.ReadingIsGood.entity.Customer;
import com.harshit.ReadingIsGood.exception.DuplicateRegisteryException;
import com.harshit.ReadingIsGood.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	public void registerCustomer(Customer customer) throws DuplicateRegisteryException
	{
		customerRepository.addCustomer(customer);
	}
	
	public List<Customer> getAllCustomers()
	{
		return customerRepository.getAllCustomers();
	}

}
