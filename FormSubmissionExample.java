import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FormSubmissionExample extends JFrame {
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextArea messageTextArea;
    private JButton submitButton;

    public FormSubmissionExample() {
        super("Form Submission Example");

        // Create UI components
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(20);
        JLabel messageLabel = new JLabel("Message:");
        messageTextArea = new JTextArea(5, 20);
        submitButton = new JButton("Submit");

        // Set layout
        setLayout(new BorderLayout());

        // Create a panel for the form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));
        formPanel.add(nameLabel);
        formPanel.add(nameTextField);
        formPanel.add(emailLabel);
        formPanel.add(emailTextField);
        formPanel.add(messageLabel);
        formPanel.add(new JScrollPane(messageTextArea));

        // Create a panel for the submit button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        // Add panels to the frame
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void submitForm() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String message = messageTextArea.getText();

        try {
            // Create a URL object with the servlet URL
            URL url = new URL("http://localhost:8080/MyServlet");

            // Open a connection to the servlet
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Write the form data to the connection's output stream
            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            writer.println("name=" + name);
            writer.println("email=" + email);
            writer.println("message=" + message);
            writer.close();

            // Get the response from the servlet
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Process the response
                // ...
                System.out.println("Form submitted successfully!");
            } else {
                System.out.println("Form submission failed. Response Code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormSubmissionExample();
            }
        });
    }
}
