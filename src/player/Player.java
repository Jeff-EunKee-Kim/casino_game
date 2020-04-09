package player;

import exception.InsufficientBalanceException;

/**
 * @author Jeff Kim
 * started 4/8/20
 */
public class Player {
    private final String name;
    private double balance;

    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Player(String name) {
        this(name, 0.0);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double debitMoney) {
        balance += debitMoney;
    }

    public void subtractBalance(double creditMoney) {
        if (balance < creditMoney) {
            String errMsg = "Insufficient balance of: ";
            errMsg += balance - creditMoney;
            throw new InsufficientBalanceException(errMsg);
        }
        balance -= creditMoney;
    }
}