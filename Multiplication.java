//Write a Java program to display the multiplication table of a number.
import java.util.Scanner;
class Multiplication {
	public static void main(String[] args)
	{
		int n;
		System.out.println("Enter the number: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " * " + i + " = "+ n * i);
		}
	}
}
