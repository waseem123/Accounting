public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(101, "Alex", 'M');
        Account account = new Account(1001, customer, 52000);

        System.out.println(account.toString());
    }
}
