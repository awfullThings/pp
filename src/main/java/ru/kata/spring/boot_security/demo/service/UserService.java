package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean deleteUser(long userId);

    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void updateUser(User updatedUser);

    void delete(long id);


}
