package com.crm.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.spring.dao.CustomerDAO;
import com.crm.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}


	@Override
	@Transactional
	public void delete(int theId) {
		
	 customerDAO.deleteCustomer(theId);
		
	}


	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		List<Customer> theCustomers = customerDAO.searchCustomers(theSearchName);
		
		return theCustomers;
	}

}
