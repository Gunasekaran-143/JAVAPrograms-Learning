import java.util.Scanner;
class SumDigits
{
 public static void main(String args[])
  { 
   int m=0,n=0,o=0;
  int x,y;
  System.out.println("Enter the number: ");
    Scanner sc = new Scanner(System.in);
    x = sc.nextInt();
    System.out.println("Enter the another value: ");
    y = sc.nextInt();
   while(x>0 && y>00)
   {
    m=x%10;
    n=y%10;
    o=o+(m*n);
    x=x/10;
    y=y/10;
   }
   System.out.println("sum of product of corresponding digits= "+o);
  }
}