public class Account {
    private int accountId;
    private Customer customer;
    private double accountBalance;

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

    @Override
    public String toString() {
        return accountId +
                ":" + customer +
                ":" + accountBalance;
    }
}
