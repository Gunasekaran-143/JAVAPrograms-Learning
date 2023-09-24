import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserForm extends Frame implements ActionListener {
    // Labels and TextFields for user input
    Label nameLabel = new Label("Name:");
    TextField nameField = new TextField(20);
    Label emailLabel = new Label("Email:");
    TextField emailField = new TextField(20);
    Label addressLabel = new Label("Address:");
    TextField addressField = new TextField(20);
    // Buttons for submit and fetch actions
    Button submitButton = new Button("Submit");
    Button fetchButton = new Button("Fetch");

    // TextArea to display fetched data
    TextArea dataTextArea = new TextArea("", 10, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);

    // Database connection variables
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public UserForm() {
        // Set up the GUI components
        setTitle("User Details Form");
        setLayout(new GridLayout(4, 2));
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(addressLabel);
        add(addressField);
        add(submitButton);
        add(fetchButton);
        // Register event listeners for submit and fetch buttons
        submitButton.addActionListener(this);
        fetchButton.addActionListener(this);
        // Set up TextArea for displaying fetched data
        dataTextArea.setEditable(false);
        // Initialize the database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // Set up the main frame
        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == submitButton) {
            // Insert user details into the database
            try {
                String name = nameField.getText();
                String email = emailField.getText();
                String address = addressField.getText();
                String sql = "INSERT INTO Userdetails(name, email, address) VALUES ('" + name + "', '" + email + "', '" + address + "')";
                stmt.executeUpdate(sql);
                // Clear the input fields after successful insert
                nameField.setText("");
                emailField.setText("");
                addressField.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (evt.getSource() == fetchButton) {
            // Fetch and display all user details from the database
            try {
                rs = stmt.executeQuery("SELECT * FROM Userdetails");
                StringBuilder dataBuilder = new StringBuilder();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    dataBuilder.append(String.format("%d\t%s\t%s\t%s\n", id, name, email, address));
                }
                // Display fetched data in a new frame
                Frame displayFrame = new Frame("User Details");
                TextArea displayTextArea = new TextArea(dataBuilder.toString(), 10, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
                displayFrame.add(displayTextArea);
                displayFrame.pack();
                displayFrame.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UserForm();
    }}
