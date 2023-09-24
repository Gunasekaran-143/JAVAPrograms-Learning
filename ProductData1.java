class ProductData {
    String name;
    int costPrice;
    int sellingPrice;
    int quantity;

    public ProductData(String name, int costPrice, int sellingPrice, int quantity) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public void printProduct() {
        System.out.println("Name: " + name);
        System.out.println("Cost Price: " + costPrice);
        System.out.println("Selling Price: " + sellingPrice);
        System.out.println("Quantity: " + quantity);
    }
}

class ProfitLossCalculation extends ProductData {
    public ProfitLossCalculation(String name, int costPrice, int sellingPrice, int quantity) {
        super(name, costPrice, sellingPrice, quantity);
    }

    public void calculate() {
        int totalCostPrice = costPrice * quantity;
        int totalSellingPrice = sellingPrice * quantity;
        int profitOrLoss = totalSellingPrice - totalCostPrice;

        System.out.println("Profit/Loss for " + name + ": " + profitOrLoss);
    }
}

public class ProductData1 {
    public static void main(String[] args) {
        ProductData[] products = new ProductData[3];

        products[0] = new ProfitLossCalculation("Product 1", 50, 80, 100);
        products[1] = new ProfitLossCalculation("Product 2", 30, 25, 50);
        products[2] = new ProfitLossCalculation("Product 3", 80, 70, 200);

        for (int i = 0; i < products.length; i++) {
            products[i].printProduct();
            ((ProfitLossCalculation) products[i]).calculate();
            System.out.println();
        }

        int totalCostPrice = 0;
        int totalSellingPrice = 0;
        int totalProfitOrLoss = 0;

        for (int i = 0; i < products.length; i++) {
            totalCostPrice += products[i].costPrice * products[i].quantity;
            totalSellingPrice += products[i].sellingPrice * products[i].quantity;
        }

        totalProfitOrLoss = totalSellingPrice - totalCostPrice;

        System.out.println("Total Profit/Loss: " + totalProfitOrLoss);
    }
}
