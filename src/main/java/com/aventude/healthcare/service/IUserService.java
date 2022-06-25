package com.aventude.healthcare.service;

import com.aventude.healthcare.domain.User;
import com.aventude.healthcare.dto.UserDTO;
import com.aventude.healthcare.exception.UserNotFoundException;

public interface IUserService {

    UserDTO saveUser(UserDTO userDTO);
    UserDTO getUserByUsername(String username) throws UserNotFoundException;
}
