package pack1;

public class Sum {

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int sum = a + b;
    System.out.println("Sum: " + sum);
  }
}

package pack1.subpack1;

public class Product {

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int product = a * b;
    System.out.println("Product: " + product);
  }
}
