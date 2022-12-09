package ra.model.daoImp;
import org.springframework.stereotype.Repository;
import ra.model.dao.customerDao;
import ra.model.entity.Customer;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class customerDaoImp implements customerDao {
    @Override
    public List<Customer> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Customer> listCustomer = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAll()}");
            ResultSet rs = callSt.executeQuery();
            listCustomer = new ArrayList<>();
            while (rs.next()){
                Customer cu = new Customer();
                cu.setCustomerID(rs.getInt("CustomerID"));
                cu.setCustomerName(rs.getString("Name"));
                cu.setCustomerEmail(rs.getString("Email"));
                cu.setCustomerAddress(rs.getString("Address"));
                listCustomer.add(cu);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCustomer;
    }

    @Override
    public Customer getByID(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Customer cu = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getByID(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            cu = new Customer();
            if(rs.next()){
                cu.setCustomerID(rs.getInt("CustomerID"));
                cu.setCustomerName(rs.getString("Name"));
                cu.setCustomerEmail(rs.getString("Email"));
                cu.setCustomerAddress(rs.getString("Address"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return cu;
    }

    @Override
    public boolean update(Customer customer) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateCustomer(?,?,?,?)}");
            callSt.setInt(1,customer.getCustomerID());
            callSt.setString(2,customer.getCustomerName());
            callSt.setString(3,customer.getCustomerEmail());
            callSt.setString(4,customer.getCustomerAddress());
            callSt.executeUpdate();
        }catch (SQLException ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
}
