package com.Pagination.Service;

import java.util.List;

import com.Pagination.Model.Customer;

public interface CustomerService {
	
	public Integer addCustomer(Customer customer)throws Exception;

	public List<Customer>getCustomerByPagination(Integer pageNo,Integer size) throws Exception;
	public List<Customer>getCustomerBySorting(Integer pageNo,Integer size,String field) throws Exception;

}
