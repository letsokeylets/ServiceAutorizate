package ru.netology.serviceautorizate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.serviceautorizate.advice.UnauthorizedUser;
import ru.netology.serviceautorizate.controller.Authorities;
import ru.netology.serviceautorizate.repository.UserRepository;
import ru.netology.serviceautorizate.user.User;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {
    private final UserRepository userRepository;


    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user: " + user.getUser() + ", password: " + user.getPassword());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}