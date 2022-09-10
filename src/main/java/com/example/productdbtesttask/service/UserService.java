package com.example.productdbtesttask.service;

import com.example.productdbtesttask.data.UserData;
import com.example.productdbtesttask.exceptions.UserAlreadyExistException;

public interface UserService {
    void register (final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String username);
}
