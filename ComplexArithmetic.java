import java.util.Scanner;

class ComplexArithmetic1 {
    private double real;
    private double imaginary;

     ComplexArithmetic1(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

     ComplexArithmetic1 add(ComplexArithmetic1 other) {
        return new ComplexArithmetic1(this.real + other.real, this.imaginary + other.imaginary);
    }

     ComplexArithmetic1 subtract(ComplexArithmetic1 other) {
        return new ComplexArithmetic1(this.real - other.real, this.imaginary - other.imaginary);
    }

    ComplexArithmetic1 multiply(ComplexArithmetic1 other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexArithmetic1(realPart, imaginaryPart);
    }
     ComplexArithmetic1 divide(ComplexArithmetic1 other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexArithmetic1(realPart, imaginaryPart);
    }


     public String toString() 
     {
        return "(" + real + " + " + imaginary + "i)";
    }
}

class ComplexArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first complex number (a + bi): ");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        ComplexArithmetic1 c1 = new ComplexArithmetic1(a1, b1);

        System.out.println("Enter second complex number (a + bi): ");
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        ComplexArithmetic1 c2 = new ComplexArithmetic1(a2, b2);

        int choice = 0;
        while (choice != 5) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ComplexArithmetic1 sum = c1.add(c2);
                    System.out.println("Sum: " + sum);
                    break;

                case 2:
                   ComplexArithmetic1 difference = c1.subtract(c2);
                    System.out.println("Difference: " + difference);
                    break;

                case 3:
                    ComplexArithmetic1 product = c1.multiply(c2);
                    System.out.println("Product: " + product);
                    break;

                case 4:
                    ComplexArithmetic1 quotient = c1.divide(c2);
                    System.out.println("Quotient: " + quotient);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

         scanner.close();
     }
 }


// import java.util.*;

// public class ComplexArithmetic {

//     private double real;
//     private double imaginary;

//     public ComplexArithmetic(double real, double imaginary) {
//         this.real = real;
//         this.imaginary = imaginary;
//     }

//     public double getReal() {
//         return real;
//     }

//     public double getImaginary() {
//         return imaginary;
//     }

//     public void add(ComplexArithmetic c) {
//         this.real += c.real;
//         this.imaginary += c.imaginary;
//     }

//     public void subtract(ComplexArithmetic c) {
//         this.real -= c.real;
//         this.imaginary -= c.imaginary;
//     }

//     public void multiply(ComplexArithmetic c) {
//         this.real = this.real * c.real - this.imaginary * c.imaginary;
//         this.imaginary = this.real * c.imaginary + this.imaginary * c.real;
//     }

//     public void divide(ComplexArithmetic c) {
//         double denominator = c.real * c.real + c.imaginary * c.imaginary;
//         this.real = (this.real * c.real + this.imaginary * c.imaginary) / denominator;
//         this.imaginary = (this.real * c.imaginary - this.imaginary * c.real) / denominator;
//     }

//     public String toString() {
//         return "(" + real + " + " + imaginary + "i)";
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Welcome to the Complex Arithmetic Calculator!");
//         System.out.println("Please enter the real and imaginary parts of the first complex number:");
//         double real1 = scanner.nextDouble();
//         double imaginary1 = scanner.nextDouble();

//         ComplexArithmetic c1 = new ComplexArithmetic(real1, imaginary1);

//         System.out.println("Please enter the real and imaginary parts of the second complex number:");
//         double real2 = scanner.nextDouble();
//         double imaginary2 = scanner.nextDouble();

//         ComplexArithmetic c2 = new ComplexArithmetic(real2, imaginary2);

//         System.out.println("What operation would you like to perform?");
//         System.out.println("1. Add");
//         System.out.println("2. Subtract");
//         System.out.println("3. Multiply");
//         System.out.println("4. Divide");

//         int operation = scanner.nextInt();

//         switch (operation) {
//             case 1:
//                 c1.add(c2);
//                 System.out.println("The sum of the two complex numbers is: " + c1);
//                 break;
//             case 2:
//                 c1.subtract(c2);
//                 System.out.println("The difference of the two complex numbers is: " + c1);
//                 break;
//             case 3:
//                 c1.multiply(c2);
//                 System.out.println("The product of the two complex numbers is: " + c1);
//                 break;
//             case 4:
//                 c1.divide(c2);
//                 System.out.println("The quotient of the two complex numbers is: " + c1);
//                 break;
//             default:
//                 System.out.println("Invalid operation.");
//                 break;
//         }
//     }
// }
