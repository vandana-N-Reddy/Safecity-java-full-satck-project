package com.safecity.service;

import com.safecity.model.User;
import com.safecity.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "EMAIL_EXISTS";
        }
        userRepository.save(user);
        return "SUCCESS";
    }

    public User login(String email, String password) {
        User u = userRepository.findByEmail(email);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
