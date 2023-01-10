//import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;


public class Main {
    public static String AccountInfo(int N, List<Account> accountList, int accountId, int operation, int amount) {
        Account ac = findAccount(accountList, accountId);
        if (ac != null) {
            switch (operation) {
                case 1:
                    ac.deposit(amount);
                    return ac.toString();
                case 2:
                    ac.withdraw(amount);
                    return ac.toString();
            }
        }
        return "ACCOUNT NOT FOUND";
    }

    private static Account findAccount(List<Account> accountList, int accountId) {
        Account ac = null;
        for (int i = 0; i < accountList.size(); i++) {
            ac = accountList.get(i);
            if (ac.getAccountId() == accountId) {
                return ac;
            }
        }
        return ac;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Account> accountList = new ArrayList<>();
        int custId, accountId, accountBalance;
        String custName;


        int N = sc.nextInt();
        if (N <= 500) {
            for (int i = 0; i < N; i++) {
                custId = sc.nextInt();
                custName = sc.next();
                accountId = sc.nextInt();
                accountBalance = sc.nextInt();

                Customer c = new Customer(custId, custName);
                Account ac = new Account(accountId, c, accountBalance);
                accountList.add(ac);
            }
            int searchId = sc.nextInt();
            int operation = sc.nextInt();
            int amount = sc.nextInt();
            System.out.println(AccountInfo(2, accountList, searchId, operation, amount));
        }
    }
}

class Customer {
    private int customerId;
    private String customerName;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return customerId +
                ":" + customerName;
    }
}

class Account {
    private int accountId;
    private Customer customer;
    private double accountBalance;
    private double withdrawalAmount;
    private double depositAmount;
//    HashMap<String, String> lastTransaction = new HashMap<>();
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");

    public Account(int accountId, Customer customer, double accountBalance) {
        this.accountId = accountId;
        this.customer = customer;
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double deposit(int depositAmount) {
        this.depositAmount = depositAmount;
        accountBalance += depositAmount;
//        Date date = Date.from(Instant.now());
//        String t_date = simpleDateFormat.format(date);
//        lastTransaction.put("transaction_date", t_date);
//        lastTransaction.put("transaction_type", "DEPOSIT");
//        lastTransaction.put("transaction_amount", depositAmount + "");
//        lastTransaction.put("transaction_status", "Successful");
//        lastTransaction.put("transaction_remark", "");
        return depositAmount;
    }

    public double withdraw(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
//        Date date = Date.from(Instant.now());
//        String t_date = simpleDateFormat.format(date);
//        lastTransaction.put("transaction_date", t_date);
//        lastTransaction.put("transaction_type", "WITHDRAWAL");
//        lastTransaction.put("transaction_amount", withdrawalAmount + "");

        if (withdrawalAmount > accountBalance) {
//            lastTransaction.put("transaction_status", "Failed");
//            System.out.println("AMOUNT EXCEED THE ACTUAL BALANCE");
            return 0;
        } else {
            accountBalance -= withdrawalAmount;
            if (accountBalance < 1000) {
                accountBalance += withdrawalAmount;
//                lastTransaction.put("transaction_status", "Failed");
//                System.out.println("INSUFFICIENT BALANCE");
                return 0;
            }
//            lastTransaction.put("transaction_status", "Successful");
            return withdrawalAmount;
        }
    }

//    public HashMap<String, String> getLastTransaction() {
//        return lastTransaction;
//    }

    @Override
    public String toString() {
        return accountId +
                ":" + customer +
                ":" + withdrawalAmount +
                ":" + depositAmount +
                ":" + accountBalance
                ;
    }
}