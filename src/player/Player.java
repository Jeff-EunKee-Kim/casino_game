package player;

import enums.Chip;
import exception.InsufficientBalanceException;
import exception.InsufficientChipsException;

/**
 * @author Jeff Kim
 * started 4/8/20
 */
public class Player {
    private final String name;
    private int balance;
    // index 0: Red chips, index 1: Blue chips, index 3: Green chips
    private int[] chips = new int[3];

    /**
     * Constructor for the player
     *
     * @param name:    Name of the player
     * @param balance: Balance of the player
     */
    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    /**
     * Constructor for the player
     *
     * @param name: name of the player
     */
    public Player(String name) {
        this(name, 0);
    }

    /**
     * Get name of the player
     *
     * @return Name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Get balance of the player
     *
     * @return Balance of the player
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Add balance to the player
     *
     * @param debitMoney: Money that is being added to the account
     */
    public void addBalance(int debitMoney) {
        balance += debitMoney;
    }

    /**
     * Subtract balance to the player
     *
     * @param creditMoney: Money that is taken out of the account
     */
    public void subtractBalance(int creditMoney) {
        if (balance < creditMoney) {
            String errMsg = "Insufficient balance of: ";
            errMsg += balance - creditMoney;
            throw new InsufficientBalanceException(errMsg);
        }
        balance -= creditMoney;
    }

    /**
     * Buy red chips, cost $1 each and saved in 0th index
     *
     * @param redChips Number of red chips to buy
     */
    public void buyRedChips(int redChips) {
        int cost = Chip.RED.getValue() * redChips;
        if (cost <= balance) {
            this.chips[0] += redChips;
            balance -= cost;
        } else {
            throw new InsufficientBalanceException("Not enough money");
        }
    }

    /**
     * Buy blue chips, cost $5 each and saved in 0th index
     *
     * @param blueChips Number of blue chips to buy
     */
    public void buyBlueChips(int blueChips) {
        int cost = Chip.BLUE.getValue() * blueChips;
        if (cost <= balance) {
            this.chips[1] += blueChips;
            balance -= cost;
        } else {
            throw new InsufficientBalanceException("Not enough money");
        }
    }

    /**
     * Buy green chips, cost $1 each and saved in 0th index
     *
     * @param greenChips Number of red chips to buy
     */
    public void buyGreenChips(int greenChips) {
        int cost = Chip.GREEN.getValue() * greenChips;
        if (cost <= balance) {
            this.chips[2] += greenChips;
            balance -= cost;
        } else {
            throw new InsufficientBalanceException("Not enough money");
        }
    }

    /**
     * Exchange chips to money
     *
     * @param redChips:  number of red chips to exchange
     * @param blueChips  Number of blue chips to exchange
     * @param greenChips Number of green chips to exchange
     */
    public void exchangeMoneyFromChips(int redChips, int blueChips, int greenChips) {
        if (redChips < chips[0]) {
            throw new InsufficientChipsException("Red");
        } else if (blueChips < chips[1]) {
            throw new InsufficientChipsException("Blue");
        } else if (greenChips < chips[2]) {
            throw new InsufficientChipsException("Green");
        }

        chips[0] -= redChips;
        chips[1] -= blueChips;
        chips[2] -= greenChips;

        int exchangedMoney = Chip.RED.getValue() * redChips + Chip.BLUE.getValue() * blueChips + Chip.GREEN.getValue() * greenChips;
        addBalance(exchangedMoney);
    }
}