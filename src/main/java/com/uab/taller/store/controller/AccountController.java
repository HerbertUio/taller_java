package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.CreateAccountRequest;
import com.uab.taller.store.domain.dto.request.UpdateAccountRequest;
import com.uab.taller.store.usecase.account.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    GetAccountByIdUseCase getAccountByIdUseCase;
    @Autowired
    GetAllAccountUseCase getAllAccountUseCase;
    @Autowired
    DeleteAccountUseCase deleteAccountUseCase;
    @Autowired
    UpdateAccountUseCase updateAccountUseCase;
    @Autowired
    CreateAccountUseCase createAccountUseCase;

    @GetMapping()
    public List<Account> getAll () {
        return getAllAccountUseCase.execute();
    }
    @GetMapping(value = "/{accountId}")
    public Account getById (@PathVariable Long accountId) {
        return getAccountByIdUseCase.execute(accountId);
    }
    @PostMapping(value = "")
    public Account save (@RequestBody CreateAccountRequest createAccountRequest) {
        return createAccountUseCase.execute(createAccountRequest);
    }
    @PutMapping(value = "/{accountId}")
    public Account update (@PathVariable Long accountId, @RequestBody UpdateAccountRequest updateAccountRequest) {
        return updateAccountUseCase.execute(accountId, updateAccountRequest);
    }
    @DeleteMapping(value = "/{accountId}")
    public void delete (@PathVariable Long accountId) {
        deleteAccountUseCase.execute(accountId);
    }
}
