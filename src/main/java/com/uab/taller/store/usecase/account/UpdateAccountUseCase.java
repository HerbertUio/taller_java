package com.uab.taller.store.usecase.account;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.UpdateAccountRequest;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase {
    @Autowired
    IAccountService accountService;
    public Account execute(Long id, UpdateAccountRequest updateAccountRequest) {
        Account accountToUpdate = accountService.getById(id);
        accountToUpdate.setNumber(accountToUpdate.getNumber());
        accountToUpdate.setCurrencyType(updateAccountRequest.getCurrencyType());
        accountToUpdate.setBalance(updateAccountRequest.getBalance());
        return accountService.save(accountToUpdate);
    }



}
