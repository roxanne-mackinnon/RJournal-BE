package com.rjournal.rjournal.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rjournal.rjournal.dto.UserCreationDto;
import com.rjournal.rjournal.dto.UserDto;
import com.rjournal.rjournal.models.UserEntity;
import com.rjournal.rjournal.repositories.UserRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class UserService {
    
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity findUserByEmail(String email) throws UsernameNotFoundException {
        Optional<UserEntity> result = userRepo.findByEmail(email);
        if (result.isEmpty()) throw new UsernameNotFoundException(String.format("User {} not found.", email));
        return result.get();
    }

    public UserEntity findUserById(Long id) throws UsernameNotFoundException {
        Optional<UserEntity> result = userRepo.findById(id);
        if (result.isEmpty()) throw new UsernameNotFoundException(String.format("User #{} not found.", id));
        return result.get();
    }

    public UserEntity createUser(UserCreationDto dto) throws EntityExistsException{
        UserEntity newUser = new UserEntity();
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(dto.getPassword());

        // check if user with email already exists
        if (! userRepo.findByEmail(newUser.getEmail()).isEmpty()) {
            throw new EntityExistsException(String.format("User with email {} already exists.", newUser.getEmail()));
        }

        return userRepo.save(newUser);
    }

    public void deleteUserByEmail(String email) throws UsernameNotFoundException {
        UserEntity user = findUserByEmail(email);
        userRepo.delete(user);
    }

    public void deleteUserById(Long id) throws UsernameNotFoundException {
        UserEntity user = findUserById(id);
        userRepo.delete(user);
    }

    public UserEntity toEntity(UserDto userDto) throws UsernameNotFoundException {
        return findUserByEmail(userDto.getEmail());
    }

    public UserDto toDto(UserEntity userEntity) {
        UserDto result = new UserDto();

        result.setId(userEntity.getId());
        result.setEmail(userEntity.getEmail());

        return result;
    }

}
