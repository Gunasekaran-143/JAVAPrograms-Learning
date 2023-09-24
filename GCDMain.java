// GCD interface
interface GCD {
    int computeGCD(int num1, int num2);
}

// Class implementing GCD interface using Euclid's algorithm
class APPROACH1 implements GCD {
    @Override
    public int computeGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return computeGCD(num2, num1 % num2);
    }
}

// Class implementing GCD interface using factor listing
class APPROACH2 implements GCD {
    @Override
    public int computeGCD(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

// Main class
public class GCDMain {
    public static void main(String[] args) {
        GCD gcd1 = new APPROACH1();
        GCD gcd2 = new APPROACH2();
        
        int num1 = 48;
        int num2 = 60;
        
        int result1 = gcd1.computeGCD(num1, num2);
        int result2 = gcd2.computeGCD(num1, num2);
        
        System.out.println("GCD using APPROACH1 (Euclid's algorithm): " + result1);
        System.out.println("GCD using APPROACH2 (Factor listing): " + result2);
    }
}
