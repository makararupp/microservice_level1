package com.makara.account.config;

import com.makara.account.entity.Account;
import com.makara.account.entity.Customer;
import com.makara.account.repository.AccountRepository;
import com.makara.account.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class SetupAccountRunner implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        Customer customer = new Customer();
        customer.setCreateDate(LocalDate.now());
        customer.setEmail("makarasam68@gmail.com");
        customer.setMobileNumber("0978290427");
        customer.setName("Sam Makara");
        customerRepository.save(customer);

        Account account = new Account();
      //  account.setAccountNumber(1L);
        account.setAccountType("Saving");
        account.setBranchAddress("Phnom Penh");
        account.setCreateDate(LocalDate.now());
        account.setCustomer(customer);
        accountRepository.save(account);
        log.info("Account created");
    }
}
