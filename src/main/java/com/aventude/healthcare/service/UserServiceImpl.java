package com.aventude.healthcare.service;

import com.aventude.healthcare.domain.User;
import com.aventude.healthcare.dto.UserDTO;
import com.aventude.healthcare.exception.UserNotFoundException;
import com.aventude.healthcare.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private UserRepository userRepository;
  private IHelperService iHelperService;

  public UserServiceImpl(UserRepository userRepository, IHelperService iHelperService) {
    this.userRepository = userRepository;
    this.iHelperService = iHelperService;
  }

  @Override
  public UserDTO saveUser(UserDTO userDTO) {
    return iHelperService.map(
        userRepository.save(iHelperService.map(userDTO, User.class)), UserDTO.class);
  }

  @Override
  public UserDTO getUserByUsername(String username) throws UserNotFoundException {
    return iHelperService.map(
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException("User not found")),
        UserDTO.class);
  }
}
