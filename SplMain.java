abstract class Special {
  abstract double process(double P, double R);
}

class Discount extends Special {

  @Override
  public double process(double P, double R) {
    double total = P + P * R / 100;
    return total;
  }
}

public class SplMain {
  public static void main(String[] args) {
    Discount discount = new Discount();
    double price = 100;
    double rate = 10;
    double total = discount.process(price, rate);
    System.out.println("Total price: " + total);
  }
}
