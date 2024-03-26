package com.Pagination.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Pagination.Entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

}
