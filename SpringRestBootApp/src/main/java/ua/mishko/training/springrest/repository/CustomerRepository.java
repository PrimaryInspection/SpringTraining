package ua.mishko.training.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mishko.training.springrest.model.Customer;

/**
 * Repository interface for {@link ua.mishko.training.springrest.model.Customer} class
 *
 * @author Andrey Mishko
 * @version 1.0
 * */

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
