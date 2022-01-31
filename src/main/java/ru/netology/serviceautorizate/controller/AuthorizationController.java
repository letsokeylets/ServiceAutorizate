package ru.netology.serviceautorizate.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import ru.netology.serviceautorizate.advice.UnauthorizedUser;
import ru.netology.serviceautorizate.service.AuthorizationService;
import ru.netology.serviceautorizate.user.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String unauthorizedUserHandle(UnauthorizedUser e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    private String handlerMethodArgumentResolver(BindException e) {
        return "User name or password is incorrect";
    }
}
