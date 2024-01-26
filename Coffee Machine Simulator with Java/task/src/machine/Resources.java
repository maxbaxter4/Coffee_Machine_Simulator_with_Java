package machine;

public enum Resources {
    WATER(400),
    MILK(540),
    COFFEE(120),
    CUPS(9),
    MONEY(550);
    private final int value;

    Resources(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
