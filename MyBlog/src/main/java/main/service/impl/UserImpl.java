package main.service.impl;

import main.repository.UserRepository;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String getUserName(Integer id) {
        return userRepository.findById(id).get().getName();
    }
}
