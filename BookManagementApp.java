import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookManagementApp extends JFrame {
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTextArea bookListTextArea;

    private Connection connection;
    private Statement statement;

    public BookManagementApp() {
        super("Book Management App");

        // Create UI components
        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField(20);
        JLabel authorLabel = new JLabel("Author:");
        authorTextField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");
        JButton refreshButton = new JButton("Refresh");

        bookListTextArea = new JTextArea(10, 30);
        bookListTextArea.setEditable(false);

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(titleLabel);
        add(titleTextField);
        add(authorLabel);
        add(authorTextField);
        add(addButton);
        add(searchButton);
        add(deleteButton);
        add(refreshButton);
        add(new JScrollPane(bookListTextArea));

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchBooks();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshBookList();
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        // Connect to the database
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase"; // Replace with your database URL
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

            // Refresh the book list
            refreshBookList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchBooks() {
        String keyword = titleTextField.getText();

        try {
            // Execute the select statement with the search condition
            String sql = "SELECT * FROM books WHERE title LIKE '%" + keyword + "%'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Clear the text area
            bookListTextArea.setText("");

            // Append search results to the text area
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                bookListTextArea.append(title + " by " + author + "\n");
            }
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
            } else {
                System.out.println("Book not found: " + title);
            }

            // Clear the text fields
            titleTextField.setText("");
            authorTextField.setText("");

            // Refresh the book list
            refreshBookList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshBookList() {
        try {
            // Execute the select statement
            String sql = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(sql);

            // Clear the text area
            bookListTextArea.setText("");

            // Append book information to the text area
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                bookListTextArea.append(title + " by " + author + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookManagementApp();
            }
        });
    }
}
