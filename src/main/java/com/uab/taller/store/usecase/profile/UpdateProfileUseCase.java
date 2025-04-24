package com.uab.taller.store.usecase.profile;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfileUseCase {


    @Autowired
    IProfileService profileService;
    @Transactional
    public Profile execute(Long id, ProfileRequest profileRequest ) {
        Profile profileToUpdate = profileService.getById(id);
        profileToUpdate.setName(profileRequest.getName());
        profileToUpdate.setLastName(profileRequest.getLastName());
        profileToUpdate.setBirthday(profileRequest.getBirthday());
        profileToUpdate.setGender(profileRequest.getGender());
        return profileService.save(profileToUpdate);
    }
}
