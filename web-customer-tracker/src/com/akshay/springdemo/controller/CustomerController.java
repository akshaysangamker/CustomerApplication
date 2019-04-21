package com.akshay.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.springdemo.dao.CustomerDAO;
import com.akshay.springdemo.entity.Customer;
import com.akshay.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers =customerservice.getCustomers();
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel) {
		
		Customer thecustomer= new Customer();
		themodel.addAttribute("customer",thecustomer);
		return "Customer-Form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerservice.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		Customer theCustomer= customerservice.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "Customer-Form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId,Model theModel) {
		customerservice.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
}