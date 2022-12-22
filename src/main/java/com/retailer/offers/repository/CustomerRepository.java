package com.retailer.offers.repository;

import org.springframework.data.repository.CrudRepository;

import com.retailer.offers.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Long> {
    public Customer findByCustomerId(Long customerId);
}
