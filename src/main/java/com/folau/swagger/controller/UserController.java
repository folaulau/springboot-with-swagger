package com.folau.swagger.controller;

import com.folau.swagger.dto.UserDTO;
import com.folau.swagger.dto.UserProfileUpdateDTO;
import com.folau.swagger.dto.UserSignUpDTO;
import com.folau.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "User", description = "User Operations")
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Sign Up", description = "Sign up a new user")
    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> signUp(@Valid @RequestBody UserSignUpDTO userSignUpDTO) {
        log.info("Sign up request received for email: {}", userSignUpDTO.getEmail());
        UserDTO userDTO = userService.signUp(userSignUpDTO);
        return ResponseEntity.status(OK).body(userDTO);
    }

    @Operation(summary = "Update Profile", description = "Update user profile")
    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateProfile(@Valid @RequestBody UserProfileUpdateDTO userProfileUpdateDTO) {
        log.info("Sign up request received for email: {}", userProfileUpdateDTO);
        UserDTO userDTO = userService.updateProfile(userProfileUpdateDTO);
        return ResponseEntity.status(OK).body(userDTO);
    }


    @Operation(summary = "Get User Profile", description = "Get user by id",
            security = { @SecurityRequirement(name = "bearer-key") })
    @GetMapping("/profile/{id}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long id) {
        log.info("Get user request received for id: {}", id);
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.status(OK).body(userDTO);
    }


    @Operation(summary = "Get Users within DOB range")
    @GetMapping("/by-dob-range")
    public ResponseEntity<List<UserDTO>> getUsersByDobRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        log.info("Get user request received for id: {}", startDate, endDate);
        List<UserDTO> userDTOs = userService.getUsersByDobRange(startDate, endDate);
        return ResponseEntity.status(OK).body(userDTOs);
    }


}