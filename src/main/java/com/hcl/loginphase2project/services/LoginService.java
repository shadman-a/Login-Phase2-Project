package com.hcl.loginphase2project.services;

import com.hcl.loginphase2project.models.User;
import com.hcl.loginphase2project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public boolean loginUser(User user) {

        Iterable<User> allUsers = userRepository.findAll();

        for (User userEntity : allUsers) {
            if (userEntity.getName().equals(user.getName()) && userEntity.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
