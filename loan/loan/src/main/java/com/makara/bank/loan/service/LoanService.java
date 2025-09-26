package com.makara.bank.loan.service;

import java.util.List;

import com.makara.bank.loan.entity.Loan;

public interface LoanService {
    Loan save(Loan loan);
    List<Loan> getList();
    List<Loan> findByCustomerId(Long customerId);
}
