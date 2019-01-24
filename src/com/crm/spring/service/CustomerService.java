package com.crm.spring.service;

import java.util.List;

import com.crm.spring.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);

	public List<Customer> searchCustomers(String theSearchName);
}
