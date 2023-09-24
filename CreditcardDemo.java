import java.util.Scanner;

class CARD {
    String cardno;
    String cust_name;
    String bank_name;

    CARD(String cardno, String cust_name, String bank_name) {
        this.cardno = cardno;
        this.cust_name = cust_name;
        this.bank_name = bank_name;
    }
}

class Creditcard extends CARD {
    double limit;

    Creditcard(String cardno, String cust_name, String bank_name, double limit) {
        super(cardno, cust_name, bank_name);
        this.limit = limit;
    }

    void display() {
        System.out.println("Card No.: " + cardno);
        System.out.println("Customer Name: " + cust_name);
        System.out.println("Bank Name: " + bank_name);
        System.out.println("Credit Limit: " + limit);
    }

    void use(double amount) {
        if (amount <= limit) {
            limit -= amount;
            System.out.println("Amount used: " + amount);
            System.out.println("Remaining credit limit: " + limit);
        } else {
            System.out.println("Transaction denied. Insufficient credit limit.");
        }
    }
}

public class CreditcardDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of credit cards to create: ");
        int n = scanner.nextInt();

        Creditcard[] cards = new Creditcard[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for credit card " + (i+1) + ":");
            System.out.print("Card No.: ");
            String cardno = scanner.next();

            System.out.print("Customer Name: ");
            String cust_name = scanner.next();

            System.out.print("Bank Name: ");
            String bank_name = scanner.next();

            System.out.print("Credit Limit: ");
            double limit = scanner.nextDouble();

            Creditcard card = new Creditcard(cardno, cust_name, bank_name, limit);
            cards[i] = card;
        }

        System.out.println("Credit cards created successfully.");

        while (true) {
            System.out.println("Enter the index of the credit card to use (0-" + (n-1) + "):");
            int index = scanner.nextInt();

            System.out.println("Enter the amount to use:");
            double amount = scanner.nextDouble();

            cards[index].use(amount);

            System.out.println("Do you want to use another credit card? (y/n)");
            String answer = scanner.next();

            if (answer.equals("n")) {
                break;
            }
        }
    }
}
