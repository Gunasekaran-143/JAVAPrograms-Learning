import java.util.Scanner;
class DigitCount
{
 public static void main(String args[])
  { 
   int m=0,n=0,x;
   System.out.println("Enter the number: ");
    Scanner sc = new Scanner(System.in);
    x = sc.nextInt();
   while(x>0)
   {
    x=x/10;
    n++;
   }  
    System.out.println("Number of digits in given number are :- " + n);
  }
}