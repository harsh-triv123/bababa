package com.travel_bnb.service;

import com.travel_bnb.entity.AppUser;
import com.travel_bnb.exception.UserAlreadyExistsException;
import com.travel_bnb.payload.AppUserDto;
import com.travel_bnb.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUserDto createUser(AppUser appUser) {

        if (appUserRepository.existsByUsername(appUser.getUsername())) {
            throw new UserAlreadyExistsException("username already exists");
        }
        if (appUserRepository.existsByEmail(appUser.getEmail())){
            throw new UserAlreadyExistsException("email already exists");
        }

        AppUser savedEntity = appUserRepository.save(appUser);
        AppUserDto appUserDto = entityToDto(savedEntity);
        return appUserDto;


    }

    // entity : dto
    public AppUserDto entityToDto(AppUser appUser) {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setId(appUser.getId());
        appUserDto.setName(appUser.getName());
        appUserDto.setEmail(appUser.getEmail());
        appUserDto.setUsername(appUser.getUsername());
        return appUserDto;

    }
}
