package com.makara.account.mapper;

import com.makara.account.dto.CustomerDTO;
import com.makara.account.entity.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerDTO dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        customer.setCreateDate(LocalDate.parse(dto.getCreateDate()));
        return customer;
    }
    public CustomerDTO toCustomerDTO(Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNumber(customer.getMobileNumber());
        dto.setCreateDate(customer.getCreateDate() != null? customer.getCreateDate().toString() : "");
        return dto;
    }

}
