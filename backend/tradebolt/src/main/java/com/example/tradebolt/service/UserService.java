package com.example.tradebolt.service;

import com.example.tradebolt.Modal.User;
import com.example.tradebolt.domain.VerificationType;

public interface UserService {

    public User findUserProfileByJwt(String jwt) throws Exception;
    public User findUserByEmail(String email) throws Exception;
    public User findUserById(Long userId) throws Exception;

}
