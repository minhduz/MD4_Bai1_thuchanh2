package ra.model.dao;

import ra.model.entity.Customer;

import java.util.List;

public interface customerDao {
    List<Customer> getAll();
    Customer getByID(int id);
    boolean update(Customer customer);
}
