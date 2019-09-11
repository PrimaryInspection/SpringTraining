package ua.mishko.training.JwtAppDemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.mishko.training.JwtAppDemo.model.Role;
import ua.mishko.training.JwtAppDemo.model.Status;
import ua.mishko.training.JwtAppDemo.model.User;
import ua.mishko.training.JwtAppDemo.repository.RoleRepository;
import ua.mishko.training.JwtAppDemo.repository.UserRepository;
import ua.mishko.training.JwtAppDemo.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoleList);
        user.setStatus(Status.ACTIVE);
        User registeredUser = userRepository.save(user);

        log.info("IN register() - user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = userRepository.findAll();
        log.info("IN getAll() - {} users found", allUsers.size());
        return allUsers;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById() - no user found by ID: {}", id);
        }
        log.info("IN findById - user: {} found by ID", result, id);
        return result;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with ID: {} successfully deleted", id);
    }
}
