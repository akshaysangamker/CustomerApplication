package com.akshay.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	
private SessionFactory sessionfactory;
	

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session currentSession =sessionfactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name",Customer.class);
		List<Customer> customers= theQuery.getResultList();
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		Session currentsession= sessionfactory.getCurrentSession();
		currentsession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentsession= sessionfactory.getCurrentSession();
		Customer theCustomer= currentsession.get(Customer.class, theId);
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentsession= sessionfactory.getCurrentSession();
		Query theQuery= currentsession.createQuery("delete from Customer where id=:CustomerId");
		theQuery.setParameter("CustomerId",theId);
		theQuery.executeUpdate();
		
		
	}

}
