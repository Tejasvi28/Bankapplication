public class Customer {
    private int accno;
    private int id;

    private  String name;
    private  int balance;

    public Customer(){
    }

    public Customer(int accno, int id, String name, int balance) {
        this.accno = accno;
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accno=" + accno +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
