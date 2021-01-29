package com.hcl.loginphase2project.services;

import com.hcl.loginphase2project.models.User;
import com.hcl.loginphase2project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    UserRepository userRepository;

    public boolean createUser(User user) {
        if(duplicateUser(user)) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    private boolean duplicateUser(User user) {
        Iterable<User> allUsers = userRepository.findAll();

        for (User userEntity : allUsers) {
            if(userEntity.getName().equals(user.getName())) {
                return false;
            }
        }
        return true;
    }


}
