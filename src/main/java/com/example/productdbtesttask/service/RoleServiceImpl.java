package com.example.productdbtesttask.service;

import com.example.productdbtesttask.dao.RoleRepository;
import com.example.productdbtesttask.data.UserData;
import com.example.productdbtesttask.entity.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository rolesRepository;

    @Override
    public void register(UserData user){
        Role role = new Role();
        BeanUtils.copyProperties(user, role);
        role.setRole("ROLE_USER");
        rolesRepository.save(role);
    }
}
