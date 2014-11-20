package java5;
public enum Coin {
    penny(1), nickel(5), dime(10), quarter(25);

    Coin(int value) { this.value = value; }

    private final int value;

    public int value() { return value; }
}