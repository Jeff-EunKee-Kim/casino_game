package slots;

/**
 * @author Vincent Sinfeugo
 */
public enum Icon {
    SEVEN(500),
    BAR(100),
    BELL(50),
    ORANGE(10),
    GRAPE(5),
    LEMON(3),
    CHERRY(1);

    private final int weight;

    Icon(int weight) {
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }
}
