package com.app.product_service.service;

import com.app.product_service.exception.UserNotFoundException;
import com.app.product_service.generated.model.User;
import com.app.product_service.mapper.UserMapper;
import com.app.product_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers() {
        List<com.app.product_service.model.User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return userMapper.toGeneratedUserList(users);
        } else {
            throw new UserNotFoundException("Users not found"); // Custom exception
        }
    }

    public User addUser(User user) {
        return userMapper.toGeneratedUser(userRepository.save(userMapper.generatedUserToUser(user)));
    }

    public User updateUser(String userId, User user) {
        com.app.product_service.model.User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setName(!Objects.equals(user.getName(), "") && user.getName() != null ? user.getName() : existingUser.getName()); // Update fields as needed
            existingUser.setEmail(!Objects.equals(user.getEmail(), "") && user.getEmail() != null ? user.getEmail() : existingUser.getEmail()); // Update fields as needed
            existingUser.setMobile(!Objects.equals(user.getMobile(), "") && user.getMobile() != null ? user.getMobile() : existingUser.getMobile()); // Update fields as needed
            return userMapper.toGeneratedUser(userRepository.save(existingUser));
        } else {
            throw new UserNotFoundException("User not found"); // Custom exception
        }
    }

    public User getUserById(String userId) {
        com.app.product_service.model.User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return userMapper.toGeneratedUser(user);
        } else {
            throw new UserNotFoundException("User not found"); // Custom exception
        }
    }

    public Void deleteUser(String userId) {
        com.app.product_service.model.User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new UserNotFoundException("User not found"); // Custom exception
        }
        return null;
    }
}
