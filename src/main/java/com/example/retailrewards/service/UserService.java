package com.example.retailrewards.service;

import com.example.retailrewards.model.UserEntity;

public interface UserService {

    UserEntity findUserById(Long id);
}
