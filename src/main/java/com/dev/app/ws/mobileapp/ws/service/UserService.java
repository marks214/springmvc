package com.dev.app.ws.mobileapp.ws.service;

import com.dev.app.ws.mobileapp.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);

}
