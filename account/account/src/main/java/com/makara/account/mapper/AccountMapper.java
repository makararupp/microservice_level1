package com.makara.account.mapper;

import com.makara.account.dto.AccountDto;
import com.makara.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toAccount(AccountDto dto){
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setBranchAddress(dto.getBranchAddress());
        account.setCreateDate(dto.getCreateDate());
       // account.setCustomerId(dto.getCustomerId());
        return account;
    }
}
