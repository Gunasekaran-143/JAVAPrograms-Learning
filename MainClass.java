// File: MainClass.java
import pack1.ArithmeticOperations;
import pack2.MathOperations;

class Calculator implements ArithmeticOperations, MathOperations {
    public void add(int a, int b) {
        int sum = a + b;
        System.out.println("Addition: " + a + " + " + b + " = " + sum);
    }

    public void sub(int a, int b) {
        int difference = a - b;
        System.out.println("Subtraction: " + a + " - " + b + " = " + difference);
    }

    public void multiply(int a, int b) {
        int product = a * b;
        System.out.println("Multiplication: " + a + " * " + b + " = " + product);
    }

    public void divide(int a, int b) {
        if (b != 0) {
            double quotient = (double) a / b;
            System.out.println("Division: " + a + " / " + b + " = " + quotient);
        } else {
            System.out.println("Error: Division by zero not allowed.");
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Perform arithmetic operations
        calculator.add(5, 3);
        calculator.sub(5, 3);

        // Perform math operations
        calculator.multiply(5, 3);
        calculator.divide(5, 3);
        calculator.divide(5, 0);
    }
}
