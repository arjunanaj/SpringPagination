package com.Pagination.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Pagination.Entity.CustomerEntity;
import com.Pagination.Model.Customer;

import com.Pagination.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	private CustomerRepository repository;

	public List<Customer> getCustomerByPagination(Integer pageNo, Integer size) throws Exception {
		List<Customer> customerList=new ArrayList<>();
		Pageable pageable=PageRequest.of(pageNo, size);
		Page<CustomerEntity> entity=repository.findAll(pageable);
		for(CustomerEntity list:entity) {
			Customer customer=new Customer();
			customer.setCustomerId(list.getCustomerId());
			customer.setCustomerName(list.getCustomerName());
			customer.setProductBuy(list.getProductBuy());
			customer.setPrice(list.getPrice());
			customerList.add(customer);
		}if(customerList.isEmpty()) {
			throw new Exception("Service.Not_found");
		}
		
		return customerList;
	}

	@Override
	public List<Customer> getCustomerBySorting(Integer pageNo, Integer size,String field) throws Exception {
		List<Customer> customerList=new ArrayList<>();
		Pageable pageable=PageRequest.of(pageNo, size).withSort(Sort.by(field).ascending());
		Page<CustomerEntity> entity=repository.findAll(pageable);
		for(CustomerEntity list:entity) {
			Customer customer=new Customer();
			customer.setCustomerId(list.getCustomerId());
			customer.setCustomerName(list.getCustomerName());
			customer.setProductBuy(list.getProductBuy());
			customer.setPrice(list.getPrice());
			customerList.add(customer);
		}if(customerList.isEmpty()) {
			throw new Exception("Service.Not_found");
		}
		
		return customerList;
		
	}

	@Override
	public Integer addCustomer(Customer customer) throws Exception {
		Optional<CustomerEntity> optional= repository.findById(customer.getCustomerId());
		if(optional.isPresent()) {
			throw new Exception("Service.Duplicate_Found");
		}
		
		 CustomerEntity entity=new CustomerEntity();
		 entity.setCustomerId(customer.getCustomerId());
		 entity.setCustomerName(customer.getCustomerName());
		 entity.setProductBuy(customer.getProductBuy());
		 entity.setPrice(customer.getPrice());
		 repository.save(entity);
		return entity.getCustomerId();
	}

	
	


	

}
