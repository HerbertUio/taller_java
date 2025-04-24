package com.uab.taller.store.usecase.user;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateUserRequest;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IAccountService;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateUserUseCase {

    @Autowired
    IUserService userService;

    @Autowired
    IProfileService profileService;
    @Autowired
    IAccountService accountService;


    public User execute(CreateUserRequest createUserRequest) {

        Profile profile = new Profile();
        profile.setName(createUserRequest.getName());
        profile.setGender(createUserRequest.getGender());
        profile.setBirthday(createUserRequest.getBirthday());
        profile.setLastName(createUserRequest.getLastName());
        profile = profileService.save(profile);

        User user = new User();
        user.setPassword(createUserRequest.getPassword());
        user.setEmail(createUserRequest.getEmail());

        Account account = new Account();
        account.setNumber(account.getNumber());
        account.setCurrencyType(createUserRequest.getCurrencyType());
        account.setBalance(createUserRequest.getBalance());
        account = accountService.save(account);

        user.setProfile(profile);
  
        return  userService.save(user);
    }
}
