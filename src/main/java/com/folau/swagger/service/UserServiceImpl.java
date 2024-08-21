package com.folau.swagger.service;

import com.folau.swagger.dto.UserDTO;
import com.folau.swagger.dto.UserProfileUpdateDTO;
import com.folau.swagger.dto.UserSignUpDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO signUp(UserSignUpDTO userSignUpDTO) {
        return UserDTO.builder()
                .id(1L)
                .email(userSignUpDTO.getEmail())
                .build();
    }

    @Override
    public UserDTO updateProfile(UserProfileUpdateDTO userProfileUpdateDTO) {
        return UserDTO.builder()
                .id(1L)
                .email(userProfileUpdateDTO.getEmail())
                .build();
    }

    @Override
    public UserDTO getById(Long id) {
        return UserDTO.builder()
                .id(1L)
                .build();
    }

    @Override
    public List<UserDTO> getUsersByDobRange(LocalDate startDate, LocalDate endDate) {
        return List.of();
    }
}
