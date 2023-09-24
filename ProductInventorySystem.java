import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ProductInventorySystem extends JFrame {
    private JButton addButton;
    private JButton viewButton;
    private JButton updateButton;
    private JButton deleteButton;

    private Connection connection;
    private Statement statement;

    public ProductInventorySystem() {
        super("Product Inventory System");

        // Create UI components
        addButton = new JButton("Add Product");
        viewButton = new JButton("View Products");
        updateButton = new JButton("Update Product");
        deleteButton = new JButton("Delete Product");

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(addButton);
        add(viewButton);
        add(updateButton);
        add(deleteButton);

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the add product form
                openAddProductForm();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the view products form
                openViewProductsForm();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the update product form
                openUpdateProductForm();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the delete product form
                openDeleteProductForm();
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        // Connect to the database
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/product_inventory"; // Replace with your database URL
            String user = "username"; // Replace with your database username
            String password = "password"; // Replace with your database password

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openAddProductForm() {
        JFrame addProductFrame = new JFrame("Add Product");
        addProductFrame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField(10);
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceTextField = new JTextField(10);
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int quantity = Integer.parseInt(quantityTextField.getText());
                double price = Double.parseDouble(priceTextField.getText());

                try {
                    String sql = "INSERT INTO products (name, quantity, price) VALUES ('" + name + "', " + quantity + ", " + price + ")";
                    statement.executeUpdate(sql);
                    System.out.println("Product added: " + name);

                    // Clear the text fields
                    nameTextField.setText("");
                    quantityTextField.setText("");
                    priceTextField.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        addProductFrame.add(nameLabel);
        addProductFrame.add(nameTextField);
        addProductFrame.add(quantityLabel);
        addProductFrame.add(quantityTextField);
        addProductFrame.add(priceLabel);
        addProductFrame.add(priceTextField);
        addProductFrame.add(saveButton);

        addProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addProductFrame.setSize(300, 200);
        addProductFrame.setLocationRelativeTo(null);
        addProductFrame.setVisible(true);
    }

    private void openViewProductsForm() {
        try {
            String sql = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(sql);

            JFrame viewProductsFrame = new JFrame("View Products");
            JTextArea productsTextArea = new JTextArea(10, 30);
            productsTextArea.setEditable(false);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                String productDetails = "ID: " + id + "\nName: " + name + "\nQuantity: " + quantity + "\nPrice: " + price + "\n\n";
                productsTextArea.append(productDetails);
            }

            JScrollPane scrollPane = new JScrollPane(productsTextArea);

            viewProductsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            viewProductsFrame.setSize(400, 300);
            viewProductsFrame.setLocationRelativeTo(null);
            viewProductsFrame.add(scrollPane);
            viewProductsFrame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openUpdateProductForm() {
        JFrame updateProductFrame = new JFrame("Update Product");
        updateProductFrame.setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Product ID:");
        JTextField idTextField = new JTextField(10);
        JLabel quantityLabel = new JLabel("New Quantity:");
        JTextField quantityTextField = new JTextField(10);
        JButton updateButton = new JButton("Update");

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());

                try {
                    String sql = "UPDATE products SET quantity = " + quantity + " WHERE id = " + id;
                    int rowsAffected = statement.executeUpdate(sql);
                    if (rowsAffected > 0) {
                        System.out.println("Product updated: ID " + id);
                    } else {
                        System.out.println("Product not found: ID " + id);
                    }

                    // Clear the text fields
                    idTextField.setText("");
                    quantityTextField.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateProductFrame.add(idLabel);
        updateProductFrame.add(idTextField);
        updateProductFrame.add(quantityLabel);
        updateProductFrame.add(quantityTextField);
        updateProductFrame.add(updateButton);

        updateProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateProductFrame.setSize(300, 150);
        updateProductFrame.setLocationRelativeTo(null);
        updateProductFrame.setVisible(true);
    }

    private void openDeleteProductForm() {
        JFrame deleteProductFrame = new JFrame("Delete Product");
        deleteProductFrame.setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Product ID:");
        JTextField idTextField = new JTextField(10);
        JButton deleteButton = new JButton("Delete");

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idTextField.getText());

                try {
                    String sql = "DELETE FROM products WHERE id = " + id;
                    int rowsAffected = statement.executeUpdate(sql);
                    if (rowsAffected > 0) {
                        System.out.println("Product deleted: ID " + id);
                    } else {
                        System.out.println("Product not found: ID " + id);
                    }

                    // Clear the text field
                    idTextField.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteProductFrame.add(idLabel);
        deleteProductFrame.add(idTextField);
        deleteProductFrame.add(deleteButton);

        deleteProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteProductFrame.setSize(300, 100);
        deleteProductFrame.setLocationRelativeTo(null);
        deleteProductFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProductInventorySystem();
    }
}
