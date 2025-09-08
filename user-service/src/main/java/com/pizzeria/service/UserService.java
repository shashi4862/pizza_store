package com.pizzeria.service;

import com.pizzeria.entity.User;

public interface UserService {
    User registerUser(User user);
    String login(String email, String password);
    User getUserByEmail(String email);
}
