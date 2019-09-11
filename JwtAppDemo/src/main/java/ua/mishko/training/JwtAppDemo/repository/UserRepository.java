package ua.mishko.training.JwtAppDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.JwtAppDemo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
