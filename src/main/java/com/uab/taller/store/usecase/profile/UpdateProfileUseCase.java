package com.uab.taller.store.usecase.profile;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfileUseCase {


    @Autowired
    IProfileService profileService;

    public Profile execute(Long id, ProfileRequest profileRequest ) {
        Profile profileToUpdate = profileService.getById(id);
        profileToUpdate.setName(profileRequest.getName());
        profileToUpdate.setBirthday(profileRequest.getBirthday());
        profileToUpdate.setGender(profileRequest.getGender());
        profileToUpdate.setGender(profileRequest.getGender());
        return profileService.save(profileToUpdate);
    }
}
