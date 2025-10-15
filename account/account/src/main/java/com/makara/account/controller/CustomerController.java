package com.makara.account.controller;

import com.makara.account.dto.CardResponseDTO;
import com.makara.account.dto.CustomerDTO;
import com.makara.account.dto.CustomerDetailDTO;
import com.makara.account.dto.LoanResponseDTO;
import com.makara.account.entity.Customer;
import com.makara.account.mapper.CustomerMapper;
import com.makara.account.service.CustomerService;
import com.makara.account.service.client.CardFeignClient;
import com.makara.account.service.client.LoanFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@Slf4j
public class CustomerController {
    @Autowired
    private  CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CardFeignClient cardFeignClient;

    @Autowired
    private LoanFeignClient loanFeignClient;

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
    @GetMapping("customerDetail/{customerId}")
    public ResponseEntity<CustomerDetailDTO> getCustomerDetail(@PathVariable Long customerId){
        CustomerDetailDTO dto =new CustomerDetailDTO();
        Customer customer = customerService.getById(customerId);
        if(customer == null){
            throw new RuntimeException("No Customer found with this id");
        }
        CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);
        List<LoanResponseDTO> loanInfo = loanFeignClient.getLoanInfo(customerId);
        List<CardResponseDTO> cardInfo = cardFeignClient.getCardInfo(customerId);

        dto.setCustomer(customerDTO);
        dto.setLoans(loanInfo);
        dto.setCards(cardInfo);

        return ResponseEntity.ok(dto);
    }

}
