// ProductData superclass
public class ProductData {
    protected String productName;
    protected double purchasePrice;
    protected double sellingPrice;
    
    public ProductData(String productName, double purchasePrice, double sellingPrice) {
        this.productName = productName;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }
    
    public void printProduct() {
        System.out.println("Product Name: " + productName);
        System.out.println("Purchase Price: $" + purchasePrice);
        System.out.println("Selling Price: $" + sellingPrice);
    }
}

// ProfitLossCalculation subclass
public class ProfitLossCalculation extends ProductData {
    public ProfitLossCalculation(String productName, double purchasePrice, double sellingPrice) {
        super(productName, purchasePrice, sellingPrice);
    }
    
    public void calculate() {
        double profitLoss = sellingPrice - purchasePrice;
        if (profitLoss > 0) {
            System.out.println("Profit: $" + profitLoss);
        } else if (profitLoss < 0) {
            System.out.println("Loss: $" + Math.abs(profitLoss));
        } else {
            System.out.println("No profit or loss");
        }
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        // Create product instances
        ProductData product1 = new ProductData("Product 1", 50.0, 80.0);
        ProductData product2 = new ProductData("Product 2", 100.0, 80.0);
        
        // Print product information
        product1.printProduct();
        System.out.println();
        product2.printProduct();
        System.out.println();
        
        // Calculate profit/loss for each product
        ProfitLossCalculation calc1 = new ProfitLossCalculation("Product 1", 50.0, 80.0);
        calc1.calculate();
        
        ProfitLossCalculation calc2 = new ProfitLossCalculation("Product 2", 100.0, 80.0);
        calc2.calculate();
    }
}
