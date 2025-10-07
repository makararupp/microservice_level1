package com.makara.bank.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makara.bank.loan.dto.LoanDTO;
import com.makara.bank.loan.entity.Loan;
import com.makara.bank.loan.mapper.LoanMapper;
import com.makara.bank.loan.service.LoanService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;
    @Autowired
    private LoanMapper loanMapper;

    @PostMapping
    public ResponseEntity<?> createLoan(@RequestBody LoanDTO dto){
        
        Loan loan = loanService.save(loanMapper.toLoan(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);

    }

    @GetMapping
    public ResponseEntity<?> getLoans(){
        return ResponseEntity.ok(loanService.getList());
    }

    // Get loan by customerId
    @GetMapping("/{customerId}")
    public ResponseEntity<?> getLoanByCustomerId(@PathVariable Long customerId){
        List<Loan> loans = loanService.findByCustomerId(customerId);
        return ResponseEntity.ok(loans);
    }    
}
