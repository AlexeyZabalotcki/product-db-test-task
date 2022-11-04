package com.example.productdbtesttask.service;

import com.example.productdbtesttask.dao.RoleRepository;
import com.example.productdbtesttask.dao.UserRepository;
import com.example.productdbtesttask.dao.UserRoleRepository;
import com.example.productdbtesttask.data.UserData;
import com.example.productdbtesttask.entity.UserRole;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository,
                               UserRepository userRepository,
                               RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(UserData user) {
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(user, userRole);
        userRole.setUser_id(userRepository.count());
        userRole.setAuthority_id(roleRepository.count());
        userRoleRepository.save(userRole);
    }
}
