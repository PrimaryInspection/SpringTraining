package ua.mishko.training.JwtAppDemo.service;

import ua.mishko.training.JwtAppDemo.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void deleteUser(Long id);

}
