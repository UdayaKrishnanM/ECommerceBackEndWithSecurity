package com.ecommerce.demo.service;

import com.ecommerce.demo.model.User;
import com.ecommerce.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public String registerNewUserAccount(User user) {
        if(userRepository.findByUsername(user.getUsername()).equals(user.getUsername())){
            return "Duplicate User";
        } else {
//            userRepository.findByUsername(user.getUsername());
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            return "Done";
        }
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
