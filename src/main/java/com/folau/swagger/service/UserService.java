package com.folau.swagger.service;

import com.folau.swagger.dto.UserDTO;
import com.folau.swagger.dto.UserProfileUpdateDTO;
import com.folau.swagger.dto.UserSignUpDTO;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    UserDTO signUp(UserSignUpDTO userSignUpDTO);

    UserDTO updateProfile(UserProfileUpdateDTO userProfileUpdateDTO);

    UserDTO getById(Long id);

    List<UserDTO> getUsersByDobRange(LocalDate startDate, LocalDate endDate);
}
