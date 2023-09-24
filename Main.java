import java.util.Scanner;
import pack1.Difference;
import pack1.Sum;
import subpack1.Product;
import subpack1.Quotient;
public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the first number: ");
double num1 = scanner.nextDouble();
System.out.print("Enter the second number: ");
double num2 = scanner.nextDouble();
double sum = Sum.calculateSum(num1, num2);
double difference = Difference.calculateDifference(num1, num2);
double product = Product.calculateProduct(num1, num2);
double quotient = Quotient.calculateQuotient(num1, num2);
System.out.println("Sum: " + sum);
System.out.println("Difference: " + difference);
System.out.println("Product: " + product);
System.out.println("Quotient: " + quotient);
scanner.close();
}
}
