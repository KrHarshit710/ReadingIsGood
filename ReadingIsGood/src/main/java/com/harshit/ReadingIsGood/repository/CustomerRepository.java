package com.harshit.ReadingIsGood.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harshit.ReadingIsGood.entity.Customer;
import com.harshit.ReadingIsGood.exception.DuplicateRegisteryException;
import com.harshit.ReadingIsGood.storage.CustomerStorage;

@Repository
public class CustomerRepository {
	
	
	@Autowired
	private CustomerStorage customerStorage;
	
	public CustomerRepository(CustomerStorage customerStorage) {
		super();
		this.customerStorage = customerStorage;
	}
	
	
	public void addCustomer(Customer customer) throws DuplicateRegisteryException
	{
		if(customerStorage.emailExists(customer.getEmail()))
		{
			throw new DuplicateRegisteryException("Email already exists, please sign in");
		}
		int id = customer.getId();
		customerStorage.addCustomer(id, customer);
	}
	
	public List<Customer> getAllCustomers()
	{
		return customerStorage.getAllCustomers();
	}

}
