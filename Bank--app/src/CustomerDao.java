import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void delCustomer(int id) throws SQLException;
    List<Customer> getCustomers() throws SQLException;
    Customer getCustomerById(int id) throws SQLException;



}
