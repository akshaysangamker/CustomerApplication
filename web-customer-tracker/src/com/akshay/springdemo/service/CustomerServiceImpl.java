package com.akshay.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.springdemo.dao.CustomerDAO;
import com.akshay.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerdao;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		
		
		// TODO Auto-generated method stub
		return customerdao.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerdao.saveCustomer(theCustomer);
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerdao.getCustomer(theId);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerdao.deleteCustomer(theId);
		
	}

}
