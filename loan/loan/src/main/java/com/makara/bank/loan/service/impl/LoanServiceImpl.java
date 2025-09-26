package com.makara.bank.loan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.makara.bank.loan.entity.Loan;
import com.makara.bank.loan.repository.LoanRepository;
import com.makara.bank.loan.service.LoanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService{

    private final LoanRepository loanRepository;

    @Override
    public Loan save(Loan loan) {
         return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getList() {
         
        return loanRepository.findAll();
    }
    
    @Override
    public List<Loan> findByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }
}
