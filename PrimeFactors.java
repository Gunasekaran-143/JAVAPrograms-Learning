import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class PrimeFactors {
  public static void main(String[] args)
  {
    int n;
    System.out.println("Enter the number: ");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    while (n % 2 == 0) {
      System.out.print(2 + " ");
        n /= 2;
    }

    for (int i = 3; i <= Math.sqrt(n); i += 2) { 
      while (n % i == 0) {
       System.out.print(i + " "); n /= i; 
     } 
   } 
   if (n > 2)
     System.out.print(n);
  }
}