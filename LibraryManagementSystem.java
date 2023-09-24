import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LibraryManagementSystem extends JFrame {
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTable bookTable;

    private Connection connection;
    private Statement statement;

    public LibraryManagementSystem() {
        super("Library Management System");

        // Create UI components
        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField(20);
        JLabel authorLabel = new JLabel("Author:");
        authorTextField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(titleLabel);
        add(titleTextField);
        add(authorLabel);
        add(authorTextField);
        add(addButton);
        add(viewButton);
        add(updateButton);
        add(deleteButton);

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewBooks();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBook();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBook();
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
            String url = "jdbc:mysql://localhost:3306/library"; // Replace with your database URL
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

    private void addBook() {
        String title = titleTextField.getText();
        String author = authorTextField.getText();

        try {
            // Execute the insert statement
            String sql = "INSERT INTO books (title, author) VALUES ('" + title + "', '" + author + "')";
            statement.executeUpdate(sql);
            System.out.println("Book added: " + title + " by " + author);

            // Clear the text fields
            titleTextField.setText("");
            authorTextField.setText("");

            // Display success message
            JOptionPane.showMessageDialog(this, "Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewBooks() {
        try {
            // Execute the select statement
            String sql = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(sql);

            // Create a table model with column names and data
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Title");
            tableModel.addColumn("Author");

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                tableModel.addRow(new Object[]{title, author});
            }

            // Create a new frame to display the book table
            JFrame tableFrame = new JFrame("Book List");
            JTable bookTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(bookTable);

            // Set frame properties
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.setSize(400, 300);
            tableFrame.setLocationRelativeTo(null); // Center the frame on the screen
            tableFrame.add(scrollPane);
            tableFrame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBook() {
        String title = titleTextField.getText();
        String author = authorTextField.getText();

        try {
            // Execute the update statement
            String sql = "UPDATE books SET author = '" + author + "' WHERE title = '" + title + "'";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Book updated: " + title + " by " + author);
                // Display success message
                JOptionPane.showMessageDialog(this, "Book updated successfully!");
            } else {
                System.out.println("Book not found: " + title);
                // Display error message
                JOptionPane.showMessageDialog(this, "Book not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Clear the text fields
            titleTextField.setText("");
            authorTextField.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteBook() {
        String title = titleTextField.getText();

        try {
            // Execute the delete statement
            String sql = "DELETE FROM books WHERE title = '" + title + "'";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Book deleted: " + title);
                // Display success message
                JOptionPane.showMessageDialog(this, "Book deleted successfully!");
            } else {
                System.out.println("Book not found: " + title);
                // Display error message
                JOptionPane.showMessageDialog(this, "Book not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Clear the text fields
            titleTextField.setText("");
            authorTextField.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementSystem();
            }
        });
    }
}
