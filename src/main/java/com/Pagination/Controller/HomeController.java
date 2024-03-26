package com.Pagination.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Pagination.Model.Customer;
import com.Pagination.Service.CustomerServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	CustomerServiceImpl customerservice;
	@Autowired
	Environment env;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) throws Exception{
		ResponseEntity<String> response=null;
		try {
			Integer id=customerservice.addCustomer(customer);
			String msg=env.getProperty("UserInterface.ADD_SUCCESS")+ id;
			response=new ResponseEntity<String> (msg,HttpStatus.CREATED);
		}catch (Exception e) {
			if(e.getMessage()!=null) {
				String msg=env.getProperty(e.getMessage());
				response=new ResponseEntity<String> (msg,HttpStatus.BAD_REQUEST);
			}
		}
		return response;
	}
	
	
	@GetMapping("/getAllDataBypage/{pageno}/{count}")
	public ResponseEntity<List<Customer>> getCustomerByPage(@PathVariable int pageno,@PathVariable int count) throws Exception{
		ResponseEntity<List<Customer>> response=null;
		try {
			List<Customer> data=customerservice.getCustomerByPagination(pageno, count);
			response=new ResponseEntity<List<Customer>>(data,HttpStatus.OK);
		}catch (Exception e) {
			throw e;
		}
		return response;
	}
	@GetMapping("/getAllDataBySort/{pageno}/{count}/{field}")
	public ResponseEntity<List<Customer>> getCustomerBySort(@PathVariable int pageno,@PathVariable int count,@PathVariable String  field) throws Exception{
		ResponseEntity<List<Customer>> response=null;
		try {
			List<Customer> data=customerservice.getCustomerBySorting(pageno, count, field);
			response=new ResponseEntity<List<Customer>>(data,HttpStatus.OK);
		}catch (Exception e) {
			throw e;
		}
		return response;
	}

}
