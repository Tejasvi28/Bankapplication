import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    Connection connection;
    public CustomerDaoImpl(){
        connection = ConnectionFactory.getConnection();
    }
    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String sql ="insert into customer (name, accno)values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setInt(2, customer.getAccno());
        preparedStatement.setInt(3, customer.getBalance());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Employee saved");
        }else{
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "update employee set name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setInt(2, customer.getAccno());
        preparedStatement.setInt(3, customer.getBalance());
        preparedStatement.setInt(4, customer.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Customer-list updated");
        }else{
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void delCustomer(int id) throws SQLException {
        String sql = "delete from customer where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Customer Rejected");
        }else{
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int balance = resultSet.getInt(3);
            int accno = resultSet.getInt(4);
            Customer customer = new Customer();
            customers.add(customer);
        }
        return customers;

    }

    @Override
    public Customer getCustomerById(int cusid) throws SQLException {
        String sql = "select * from employee where id = " + cusid;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        Customer customer = null;
        if (resultSet != null) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int balance = resultSet.getInt(3);
            int accno = resultSet.getInt(4);
            customer = new Customer();
        } else {
            System.out.println("no record found");
        }
        return customer;
    }
}

