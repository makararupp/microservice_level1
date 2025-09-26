package com.makara.account.controller;

import com.makara.account.dto.AccountDto;
import com.makara.account.entity.Account;
import com.makara.account.mapper.AccountMapper;
import com.makara.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    private AccountService  accountService;
    @Autowired
    private AccountMapper accountMapper;


    @PostMapping
    public ResponseEntity<?> saveAccount(@RequestBody AccountDto dto){
        Account account = accountMapper.toAccount(dto);
        account = accountService.save(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<?> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId){
        return ResponseEntity.ok(accountService.getById(accountId));
    }

}
