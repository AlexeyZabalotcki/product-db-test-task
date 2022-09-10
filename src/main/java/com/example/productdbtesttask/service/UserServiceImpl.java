package com.example.productdbtesttask.service;

import com.example.productdbtesttask.dao.UserRepository;
import com.example.productdbtesttask.data.UserData;
import com.example.productdbtesttask.entity.UserEntity;
import com.example.productdbtesttask.exceptions.UserAlreadyExistException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(UserData user) throws UserAlreadyExistException {

         if(checkIfUserExist(user.getUsername())){
            throw new UserAlreadyExistException("User already exists for this username");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setEnabled(true);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }

    private void encodePassword(UserEntity target, UserData source) {
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }

    @Override
    public boolean checkIfUserExist(String username) {
        return userRepository.findUserEntityByUsername(username) != null;
    }
}
