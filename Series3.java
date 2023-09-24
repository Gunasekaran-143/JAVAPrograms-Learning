 
import java.util.Scanner;
 
public class Series3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Number of rows you want in this pattern?");
 
        int rows = scanner.nextInt();
 
        System.out.println("----Pattern is----");
 
        for (int i = 1; i <= rows; i++) 
        {
            for (int j = i; j >= 1; j--)
            {
                System.out.print(j+" ");
            }
 
            System.out.println();
        }

    }
}