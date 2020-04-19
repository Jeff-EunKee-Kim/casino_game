package player;

/**
 * @author Vincent Sinfuego
 */
public class RouletteBet extends Bet{
    private static int bet;

    private int[] numberBets;
    private int evenBet;
    private int oddBet;
    private int highBet;
    private int lowBet;
    private int totalBet;

    public RouletteBet(Player player, int[] numberBets, int evenBet, int oddBet, int highBet, int lowBet, int totalBet) {
        super(player, totalBet);
        this.numberBets = numberBets;
        this.evenBet = evenBet;
        this.oddBet = oddBet;
        this.highBet = highBet;
        this.lowBet = lowBet;
        this.totalBet = totalBet;
    }
}
