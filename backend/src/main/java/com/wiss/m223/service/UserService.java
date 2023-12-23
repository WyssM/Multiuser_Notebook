package com.wiss.m223.service;

import com.wiss.m223.model.User;
import com.wiss.m223.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * These service classes contain the business logic of the application. They can contain methods
 * that perform operations on the repository classes and process or manipulate the results accordingly.
 * I'm adding methods
 * that perform specific logic for each entity, such as creating, editing, or deleting data.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public <UserDTO> void createUser(UserDTO userDTO) {

        User user = new User();
        userRepository.save(user);
    }

    public <Permissions> void changePermissions(Long userId, Permissions permissions) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPermissions(permissions);
            userRepository.save(user);
        }
    }

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }
}

