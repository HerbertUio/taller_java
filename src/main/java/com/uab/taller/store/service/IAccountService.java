package com.uab.taller.store.service;

import com.uab.taller.store.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();
    Account getById(Long id);
    void deleteById(Long id);
    Account save(Account account);
}