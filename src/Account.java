public class Account {
    private int accountId;
    private Customer customer;
    private double accountBalance;
    private double withdrawalAmount;
    private double depositAmount;

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
        return depositAmount;
    }

    public double withdraw(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
        if (withdrawalAmount > accountBalance) {
            System.out.println("INSUFFICIENT BALANCE");
            return 0;
        }
        accountBalance -= withdrawalAmount;
        return withdrawalAmount;
    }

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
