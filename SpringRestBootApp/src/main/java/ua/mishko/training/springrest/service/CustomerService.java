package ua.mishko.training.springrest.service;

import ua.mishko.training.springrest.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void save(Customer customer);

    void delete(Long id);

    List<Customer> getAll();


}
