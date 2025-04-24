package com.uab.taller.store.usecase.user;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

    @Autowired
    IUserService userService;
    @Transactional

    public User execute(Long id, UserRequest userRequest) {
        User userToUpdate = userService.getById(id);
        userToUpdate.setEmail(userRequest.getEmail());
        userToUpdate.setPassword(userRequest.getPassword());
        return userService.save(userToUpdate);
    }
}
