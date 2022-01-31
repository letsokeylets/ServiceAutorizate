package ru.netology.serviceautorizate.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.serviceautorizate.advice.InvalidCredentials;
import ru.netology.serviceautorizate.advice.UnauthorizedUser;
import ru.netology.serviceautorizate.service.AuthorizationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String invalidCredentialsHandle(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String unauthorizedUserHandle(UnauthorizedUser e) {
        return e.getMessage();
    }
}
