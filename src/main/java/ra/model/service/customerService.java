package ra.model.service;

import ra.model.entity.Customer;

import java.util.List;

public interface customerService {

    List<Customer> getAll();
    Customer getByID(int id);
    boolean update(Customer customer);
}
