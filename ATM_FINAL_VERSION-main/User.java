import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private double balance;
    private int failedAttempts;
    private boolean blocked;
    private ArrayList<Transaction> transactions;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.failedAttempts = 0;
        this.blocked = false;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }
    public int getFailedAttempts() { return failedAttempts; }
    public boolean isBlocked() { return blocked; }

    public void setBlocked(boolean blocked) { this.blocked = blocked; }
    public void resetAttempts() { this.failedAttempts = 0; }
    public void increaseAttempts() { this.failedAttempts++; }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance || amount <= 0) return false;
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));
        return true;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}