package ua.mishko.training.JwtAppDemo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.mishko.training.JwtAppDemo.model.User;
import ua.mishko.training.JwtAppDemo.security.jwt.JwtUser;
import ua.mishko.training.JwtAppDemo.security.jwt.JwtUserFactory;
import ua.mishko.training.JwtAppDemo.service.UserService;

@Service
@Slf4j
public class JwtUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null){
            throw  new UsernameNotFoundException("User with username: " + username + "not found ");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);

        return jwtUser;

    }
}
