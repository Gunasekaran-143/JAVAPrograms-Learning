import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentGUI extends JFrame {

    private JTextField nameField, ageField, gradeField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private JTextArea resultArea;

    private Connection connection;
    private Statement statement;

    public StudentGUI() {
        super("Student Database CRUD");

        // Create the GUI components
        nameField = new JTextField(20);
        ageField = new JTextField(3);
        gradeField = new JTextField(5);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        viewButton = new JButton("View All");

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });

        // Create a panel and add components to it
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        // Set layout for the main frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        // Set frame properties
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Connect to the database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "username", "");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addStudent() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();

        try {
            String query = "INSERT INTO students (name, age, grade) VALUES ('" + name + "', " + age + ", '" + grade + "')";
            statement.executeUpdate(query);
            resultArea.append("Student added: " + name + "\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateStudent() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();

        try {
            String query = "UPDATE students SET age = " + age + ", grade = '" + grade + "' WHERE name = '" + name + "'";
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                resultArea.append("Student updated: " + name + "\n");
            } else {
                resultArea.append("Student not found: " + name + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteStudent() {
        String name = nameField.getText();

        try {
            String query = "DELETE FROM students WHERE name = '" + name + "'";
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                resultArea.append("Student deleted: " + name + "\n");
            } else {
                resultArea.append("Student not found: " + name + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewStudents() {
        resultArea.setText("");

        try {
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");

                resultArea.append("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentGUI();
            }
        });
    }
}
