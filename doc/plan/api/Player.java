/**
 * This class will be responsible for creating players, who will be able to play the game, buy chips, place bets, and add more money to the account
 */
public interface Player {
    String name;
    int balance;
    int currentBet;
    int chips;

    boolean checkBalance(int bet);

    void addBalance(int money);

    void addChips(int chips);

    int placeBet(int chips);

    int getCurrentBet();
}