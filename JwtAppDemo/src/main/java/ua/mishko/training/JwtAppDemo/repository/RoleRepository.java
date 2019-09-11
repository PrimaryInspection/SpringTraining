package ua.mishko.training.JwtAppDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.JwtAppDemo.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
