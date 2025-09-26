package com.makara.account.service;

import com.makara.account.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getCustomers();

    Customer getById(Long id);
}
