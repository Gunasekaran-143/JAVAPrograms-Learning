import java.util.Scanner;

class TelephoneIndex {
    private String[] names;
    private String[] numbers;
    private int size;

    public TelephoneIndex(int capacity) {
        names = new String[capacity];
        numbers = new String[capacity];
        size = 0;
    }

    public void addEntry(String name, String number) {
        if (size < names.length) {
            names[size] = name;
            numbers[size] = number;
            size++;
        } else {
            System.out.println("Telephone index is full.");
        }
    }

    public void displayAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(names[i] + " : " + numbers[i]);
        }
    }

    public void searchByName(String query) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (names[i].toLowerCase().startsWith(query.toLowerCase())) {
                System.out.println(names[i] + " : " + numbers[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching name found.");
        }
    }
}

class TelephoneIndexMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TelephoneIndex index = new TelephoneIndex(10);
        index.addEntry("Jennie", "246-3320");
        index.addEntry("Lisa", "234-5678");
        index.addEntry("Jisoo", "245-6789");
        index.addEntry("Rose", "256-7890");

        System.out.println("\n Enter Name and Number for Telephone:");
        String name = input.nextLine();
        String number = input.nextLine();
        index.addEntry(name,number);

        System.out.print("\n Enter a name or partial name to search: ");
        String query = input.nextLine();
        index.searchByName(query);


        System.out.println("\n Telephone index entries:");
        index.displayAll();
    }
}
