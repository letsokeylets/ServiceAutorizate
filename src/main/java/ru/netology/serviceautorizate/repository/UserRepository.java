package ru.netology.serviceautorizate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.serviceautorizate.controller.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.netology.serviceautorizate.controller.Authorities.DELETE;
import static ru.netology.serviceautorizate.controller.Authorities.READ;
import static ru.netology.serviceautorizate.controller.Authorities.WRITE;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("admin") && password.equals("1234"))
            return Arrays.asList(READ, WRITE, DELETE);
        return new ArrayList<>();
    }
}
