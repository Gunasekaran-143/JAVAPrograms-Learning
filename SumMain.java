package pack1.subpack1;

public class Quotient {

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int quotient = a / b;
    System.out.println("Quotient: " + quotient);
  }
}

public class SumMain {

  public static void main(String[] args) {
    System.out.println("Enter two numbers: ");
    int a = Integer.parseInt(System.console().readLine());
    int b = Integer.parseInt(System.console().readLine());

    System.out.println("Sum: ");
    Sum.main(new String[] {a + "", b + ""});

    System.out.println("Product: ");
    Product.main(new String[] {a + "", b + ""});

    System.out.println("Quotient: ");
    Quotient.main(new String[] {a + "", b + ""});
  }
}
