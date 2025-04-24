package com.uab.taller.store.service;

import com.uab.taller.store.domain.Profile;

import java.util.List;

public interface IProfileService {
    List<Profile> getAll();
    Profile getById(Long id);
    void deleteById(Long id);
    Profile save(Profile profile);
}
