package com.harshit.ReadingIsGood.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.harshit.ReadingIsGood.entity.Customer;

@Component
public class CustomerStorage {
	
	Map<Integer,Customer> customers;

	public CustomerStorage() {
		super();
		this.customers = new HashMap<>();
	}
	
	public void addCustomer(int id, Customer customer)
	{
		customers.put(id, customer);
	}
	
	public Customer getCustomer(int id)
	{
		if(customers.containsKey(id))
			return customers.get(id);
		else
			return null;
	}
	
	public List<Customer> getAllCustomers()
	{
		return customers.values().stream().collect(Collectors.toList());
	}
	
	public boolean emailExists(String email)
	{
		return customers.values().stream().map(Customer::getEmail).collect(Collectors.toList()).contains(email);
	}

}
