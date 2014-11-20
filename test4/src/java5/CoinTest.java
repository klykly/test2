package java5;
public class CoinTest {
    public static void main(String[] args) {
        for (Coin c : Coin.values()) // ¹Ù²ï ºÎºÐ
            System.out.println(c + ":   \t"
                  + c.value() +"? \t" + color(c));
    }
    private enum CoinColor { copper, nickel, silver }
    private static CoinColor color(Coin c) {
        switch(c) {
          case penny:   return CoinColor.copper;
          case nickel:  return CoinColor.nickel;
          case dime:
          case quarter: return CoinColor.silver;
          default: throw new AssertionError("Unknown coin: " + c);
        }
    }
}