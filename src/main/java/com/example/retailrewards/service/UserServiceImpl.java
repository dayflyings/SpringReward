package com.example.retailrewards.service;

import com.example.retailrewards.dao.UserDAO;
import com.example.retailrewards.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserEntity findUserById(Long id) {
        UserEntity user = userDAO.findById(id).orElse(null);
        return user;
    }
}
