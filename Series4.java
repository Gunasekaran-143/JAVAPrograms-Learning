import java.util.*;
public class Series4
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of x ");
        int x = s.nextInt();
        System.out.println("Enter the value of last exponent 'n' ");
        int n = s.nextInt();
        int sum = 0;
        for (int i = 1, j = 1; i <= n; i = i + 2, j++)
        {
            if (j % 2 == 0)
            sum -= Math.pow(x, i);
            else
            sum += Math.pow(x, i);
        }
        System.out.println("Sum of the series is " + sum);
    }
}