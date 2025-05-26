package com.uab.taller.store.usecase.user;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UpdateUserUseCase {

    @Autowired
    IUserService userService;
    @Autowired
    IProfileService profileService;
    @Transactional
    public User execute(Long id, UserRequest userRequest) {
        User userToUpdate = userService.getById(id);

        if (userToUpdate == null) {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado.");
        }
        userToUpdate.setEmail(userRequest.getEmail());

        // Solo actualizar la contraseña si se proporciona un nuevo valor
        // Esto coincide con la lógica del frontend de no enviar la contraseña si está vacía.
        if (StringUtils.hasText(userRequest.getPassword())) { // Verifica que no sea null, vacía o solo espacios en blanco
            userToUpdate.setPassword(userRequest.getPassword());
        }

        // Actualizar campos del Profile asociado
        Profile profileToUpdate = userToUpdate.getProfile();
        if (profileToUpdate == null) {
            // Esto no debería ocurrir si un usuario siempre tiene un perfil,
            // pero es una buena práctica manejarlo. Podrías crear uno nuevo o lanzar un error.
            throw new RuntimeException("El usuario con ID " + id + " no tiene un perfil asociado.");
        }

        profileToUpdate.setName(userRequest.getName());
        profileToUpdate.setLastName(userRequest.getLastName());
        // No actualizamos gender o birthday aquí, ya que UserRequest no los incluye.
        // Si necesitas actualizarlos, UserRequest debería incluirlos y se actualizarían aquí.

        // Guardar el perfil actualizado.
        // Spring Data JPA a menudo maneja esto si la relación es @OneToOne con CascadeType.ALL,
        // pero un save explícito asegura la persistencia.
        profileService.save(profileToUpdate);

        // Guardar el usuario actualizado (esto también persistirá los cambios en el perfil si hay cascada)
        return userService.save(userToUpdate);
    }
}
