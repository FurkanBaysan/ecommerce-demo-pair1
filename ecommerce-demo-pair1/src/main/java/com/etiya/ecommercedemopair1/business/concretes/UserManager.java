package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.UserService;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import com.etiya.ecommercedemopair1.repository.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) { // Dependency Injection
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id);
    }
}
