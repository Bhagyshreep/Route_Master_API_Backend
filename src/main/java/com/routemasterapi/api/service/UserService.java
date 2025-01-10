package com.routemasterapi.api.service;

import com.routemasterapi.api.entity.UserEntity;
import com.routemasterapi.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Create a new user
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Update an existing user
    public Optional<UserEntity> updateUser(Integer id, UserEntity updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(existingUser);
        });
    }

    // Delete a user
    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
