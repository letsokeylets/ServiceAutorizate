package ru.netology.serviceautorizate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.serviceautorizate.controller.Authorities;
import ru.netology.serviceautorizate.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.netology.serviceautorizate.controller.Authorities.DELETE;
import static ru.netology.serviceautorizate.controller.Authorities.READ;
import static ru.netology.serviceautorizate.controller.Authorities.WRITE;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(User user) {
        if (user.getUser().equals("admin") && user.getPassword().equals("1234"))
            return Arrays.asList(READ, WRITE, DELETE);
        return new ArrayList<>();
    }
}
