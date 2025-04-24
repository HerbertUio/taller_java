package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.usecase.profile.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {


    @Autowired
    GetProfileByIdUseCase getProfileByIdUseCase;

    @Autowired
    GetAllProfileUseCase getAllProfileUseCase;

    @Autowired
    DeleteProfileUseCase deleteProfileUseCase;

    @Autowired
    UpdateProfileUseCase updateProfileUseCase;

    @Autowired
    CreateProfileUseCase createProfileUseCase;



    @GetMapping()
    public List<Profile> getAll() {
        return getAllProfileUseCase.execute();
    }

    @GetMapping(value = "/{userId}")
    public Profile getById(@PathVariable Long userId) {
        return getProfileByIdUseCase.execute(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        deleteProfileUseCase.execute(userId);
    }


    @PostMapping("")
    public Profile save(@RequestBody ProfileRequest profileRequest) {
        return createProfileUseCase.execute(profileRequest);
    }

    @PutMapping("/{id}")
    public Profile update(@PathVariable long id, @RequestBody ProfileRequest profileRequest) {
        return updateProfileUseCase.execute(id,profileRequest);
    }
}
