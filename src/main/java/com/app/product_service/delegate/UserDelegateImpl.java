package com.app.product_service.delegate;

import com.app.product_service.generated.api.UsersApiDelegate;
import com.app.product_service.generated.model.User;
import com.app.product_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Service
public class UserDelegateImpl implements UsersApiDelegate {
    @Autowired
    UserService userService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UsersApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String userId) {
        return new ResponseEntity<>(userService.deleteUser(userId), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<User> getUserById(String userId) {
        return new ResponseEntity<>(userService.getUserById(userId), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUserById(String userId, User user) {
        return new ResponseEntity<>(userService.updateUser(userId, user), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> usersPost(User user) {
        return new ResponseEntity<>(userService.addUser(user), null, HttpStatus.CREATED);
    }
}
