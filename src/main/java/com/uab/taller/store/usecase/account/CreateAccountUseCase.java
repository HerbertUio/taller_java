package com.uab.taller.store.usecase.account;


import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateAccountRequest;
import com.uab.taller.store.service.IAccountService;
import com.uab.taller.store.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {
    @Autowired
    IAccountService accountService;
    @Autowired
    IUserService userService;
    @Transactional
    public Account execute(CreateAccountRequest accountRequest) {
        User user = userService.getById(accountRequest.getUserId());
        if (user == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        Account account = new Account();
        account.setCurrencyType(accountRequest.getCurrencyType());
        account.setBalance(accountRequest.getBalance());
        account.setUser(user);
        account = accountService.save(account);
        return account;

    }
}
