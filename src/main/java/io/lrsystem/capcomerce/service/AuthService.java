package io.lrsystem.capcomerce.service;

import io.lrsystem.capcomerce.entites.User;
import io.lrsystem.capcomerce.service.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long id) {
        User me = userService.authenticated();

        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(id)) {
            throw new ForbiddenException("Access denied");
        }
    }

}
