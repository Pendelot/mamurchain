package com.mamurchain.mamurchain.service;

import com.mamurchain.mamurchain.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    User saveUser(User user);

    boolean isEmailTaken(String email); // ✅ Ekledik
}
