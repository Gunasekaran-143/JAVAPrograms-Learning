import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UserGUI extends JFrame {
    private JTextArea textArea;
    private JButton saveButton, loadButton, displayButton;

    public UserGUI() {
        super("User GUI");

        // Initialize UI components
        textArea = new JTextArea(10, 40);
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        displayButton = new JButton("Display");

        // Add UI components to the layout
        JPanel panel = new JPanel();
        panel.add(saveButton);
        panel.add(loadButton);
        panel.add(displayButton);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Add event listeners to the buttons
        // saveButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         try {
        //             // Open file for writing
        //             PrintWriter writer = new PrintWriter("userDetails.txt");

        //             // Write text area content to file
        //             writer.write(textArea.getText());

        //             // Close file
        //             writer.close();

        //             JOptionPane.showMessageDialog(null, "Data saved successfully!");

        //         } catch (Exception ex) {
        //             JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        //         }
        //     }
        // });
        saveButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            // Open file for writing
            FileOutputStream outputStream = new FileOutputStream("userDetails.txt");

            // Write text area content to file
            outputStream.write(textArea.getText().getBytes());

            // Close file
            outputStream.close();

            JOptionPane.showMessageDialog(null, "Data saved successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
});


        // loadButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         try {
        //             // Open file for reading
        //             BufferedReader reader = new BufferedReader(new FileReader("userDetails.txt"));

        //             // Read file content
        //             StringBuilder content = new StringBuilder();
        //             String line;
        //             while ((line = reader.readLine()) != null) {
        //                 content.append(line).append("\n");
        //             }

        //             // Close file
        //             reader.close();

        //             // Set text area content to file content
        //             textArea.setText(content.toString());

        //             JOptionPane.showMessageDialog(null, "Data loaded successfully!");

        //         } catch (Exception ex) {
        //             JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        //         }
        //     }
        // });

        loadButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            // Open file for reading
            FileInputStream inputStream = new FileInputStream("userDetails.txt");

            // Read file content
            byte[] buffer = new byte[1024];
            StringBuilder content = new StringBuilder();
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                content.append(new String(buffer, 0, bytesRead));
            }

            // Close file
            inputStream.close();

            // Set text area content to file content
            textArea.setText(content.toString());

            JOptionPane.showMessageDialog(null, "Data loaded successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
});


        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Open file for reading
                    BufferedReader reader = new BufferedReader(new FileReader("userDetails.txt"));

                    // Read file content
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }

                    // Close file
                    reader.close();

                    // Open a new frame to display the file content
                    JFrame displayFrame = new JFrame("Display");
                    JTextArea displayTextArea = new JTextArea(10, 40);
                    displayTextArea.setEditable(false);
                    displayTextArea.setText(content.toString());
                    displayFrame.add(new JScrollPane(displayTextArea), BorderLayout.CENTER);
                    displayFrame.pack();
                    displayFrame.setVisible(true);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Set frame properties
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserGUI();
    }
}
