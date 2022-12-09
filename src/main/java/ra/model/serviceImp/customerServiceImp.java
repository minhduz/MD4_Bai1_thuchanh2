package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dao.customerDao;
import ra.model.entity.Customer;
import ra.model.service.customerService;

import java.util.List;
@Service
public class customerServiceImp implements customerService {
    @Autowired
    private ra.model.dao.customerDao customerDao;
    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer getByID(int id) {
        return customerDao.getByID(id);
    }

    @Override
    public boolean update(Customer customer) {
        return customerDao.update(customer);
    }
}
