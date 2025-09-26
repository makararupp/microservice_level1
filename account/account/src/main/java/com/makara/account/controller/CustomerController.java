package com.makara.account.controller;

import com.makara.account.dto.CustomerDTO;
import com.makara.account.entity.Customer;
import com.makara.account.mapper.CustomerMapper;
import com.makara.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private  CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto){
        Customer customer = customerMapper.toCustomer(dto);
        customer = customerService.save(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.getById(customerId));
    }

}
