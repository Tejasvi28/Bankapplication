import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // employee dao
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag){
            System.out.println("******************************");
            System.out.println("Select from the option below");
            System.out.println("******************************");
            System.out.println("PRESS 1: Add Customer");
            System.out.println("PRESS 2: Update Customer");
            System.out.println("PRESS 3: Delete Customer");
            System.out.println("PRESS 4: Get All Customers");
            System.out.println("PRESS 5: Get Customer By Id");
            System.out.println("PRESS 6: Exit");

            int input = scanner.nextInt();
            switch (input){
                case 1: {
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Accno.: ");
                    int accno = Integer.parseInt(scanner.next());
                    System.out.print("Enter Balance.: ");
                    int balance = Integer.parseInt(scanner.next());

                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setAccno(accno);
                    customer.setBalance(balance);
                    customerDao.addCustomer(customer);
                    break;
                }
                case 2:
                    System.out.println("update employee");
                    break;
                case 3:
                    System.out.println("delete");
                    break;
                case 4:{
                    // get all employee
                    List<Customer> customerList = customerDao.getCustomers();
                    for(Customer customer : customerList){
                        System.out.println(customer);
                    }
                    break;
                }

                case 5:
                    System.out.println("get by id");
                    break;
                case 6:
                    System.out.println("Thank you");
                    System.out.println("Exiting....");
                    flag = false;
                    break;
                default:
                    System.out.println("choose between 1 - 6");

            }
        }



    }

}