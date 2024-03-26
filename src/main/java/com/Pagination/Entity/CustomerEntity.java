package com.Pagination.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cutomer")
public class CustomerEntity {
	
	@Id
	
	@Column
	private Integer customerId;
	@Column
	private String customerName;
	@Column
	private Integer productBuy;
	@Column
	private Integer price;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getProductBuy() {
		return productBuy;
	}
	public void setProductBuy(Integer productBuy) {
		this.productBuy = productBuy;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
