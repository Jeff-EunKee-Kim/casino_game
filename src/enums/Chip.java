package enums;

/**
 * @author Jeff Kim
 * started 4/8/20
 */
public enum Chip {
    RED(1),
    BLUE(5),
    GREEN(10);

    private final int value;

    Chip(int value) {
        this.value = value;
    }

    /**
     * Get chip value
     * @return value of the chip
     */
    public int getValue() {
        return this.value;
    }

}
