import javax.swing.*;

public class MyGUI extends JFrame {

    public MyGUI() {
        super("My GUI");

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        // Create a group for the radio buttons
        ButtonGroup group = new ButtonGroup();

        // Create the radio buttons and add them to the group and panel
        JRadioButton radio1 = new JRadioButton("Option 1");
        JRadioButton radio2 = new JRadioButton("Option 2");
        group.add(radio1);
        group.add(radio2);
        panel.add(radio1);
        panel.add(radio2);

        // Create the check box and add it to the panel
        JCheckBox checkBox = new JCheckBox("Check Box");
        panel.add(checkBox);

        // Add the panel to the frame
        add(panel);

        // Set frame properties
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
