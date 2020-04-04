public interface Bet {
    Player getPlayer();
    boolean isValidBet();
    void placeBet(Player player);
}