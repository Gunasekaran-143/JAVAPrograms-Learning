import java.util.Scanner;
class  KthDigit
{
 public static void main(String args[])
 {
  int m=0;
  int x,y;
  System.out.println("Enter the number: ");
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		System.out.println("Enter the k value: ");
		y = sc.nextInt();
  for(int i=0; i<y; i++)
  {
   m=x%10;
   x=x/10;
  }
  System.out.println(y+"th digit from last is ="+m);
 }
}