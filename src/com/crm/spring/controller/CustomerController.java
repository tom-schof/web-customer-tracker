package com.crm.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.spring.entity.Customer;
import com.crm.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject the customerDAO
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get the customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		//return the customer list
		return "list-customers";
	}
	
	@GetMapping("/new")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using the service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate teh form
		theModel.addAttribute("customer", theCustomer);
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.delete(theId);
		
		return "redirect:/customer/list" ;
		
	}
	
	@PostMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";		
	}

}













	
	

