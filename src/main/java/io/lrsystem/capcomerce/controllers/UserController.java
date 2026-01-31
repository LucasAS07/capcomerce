package io.lrsystem.capcomerce.controllers;

import io.lrsystem.capcomerce.dto.UserDTO;
import io.lrsystem.capcomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping("/me")
    public ResponseEntity<UserDTO> userMe() {
        return ResponseEntity.ok(userService.getMe());
    }

}
