package player;

import exception.InsufficientBalanceException;

/**
 * @author Jeff Kim
 * started 4/8/20
 */
public class Player {
    private final String name;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public Player(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int debitMoney) {
        balance += debitMoney;
    }

    public void subtractBalance(int creditMoney) {
        if (balance < creditMoney) {
            String errMsg = "Insufficient balance of: ";
            errMsg += balance - creditMoney;
            throw new InsufficientBalanceException(errMsg);
        }
        balance -= creditMoney;
    }
}