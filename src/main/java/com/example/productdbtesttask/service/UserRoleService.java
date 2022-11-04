package com.example.productdbtesttask.service;

import com.example.productdbtesttask.data.UserData;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {

    void register (final UserData user);
}
