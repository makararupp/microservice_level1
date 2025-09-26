package com.makara.account.service;

import com.makara.account.entity.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);

    List<Account> getAccounts();

    Account getById(Long id);
}
