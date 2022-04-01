package com.dev.app.ws.mobileapp.ws.service.impl;

import com.dev.app.ws.mobileapp.ws.UserRepository;
import com.dev.app.ws.mobileapp.ws.io.entity.UserEntity;
import com.dev.app.ws.mobileapp.ws.service.UserService;
import com.dev.app.ws.mobileapp.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findUserByEmail((user.getEmail())) != null) throw new RuntimeException("Record already exists");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
