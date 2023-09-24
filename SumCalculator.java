import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumCalculator {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Sum Calculator");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(8, 2));

        Label label1 = new Label("Number 1:");
        TextField textField1 = new TextField();
        Label label2 = new Label("Number 2:");
        TextField textField2 = new TextField();
        Label label3 = new Label("Sum:");
        TextField textField3 = new TextField();
        textField3.setEditable(false);

        Button button = new Button("ADD");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double sum = num1 + num2;
                    textField3.setText(Double.toString(sum));
                } catch (NumberFormatException ex) {
                    textField3.setText("Invalid input!");
                }
            }
        });
Button button1 = new Button("Sub");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double sum = num1 - num2;
                    textField3.setText(Double.toString(sum));
                } catch (NumberFormatException ex) {
                    textField3.setText("Invalid input!");
                }
            }
        });

        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(label3);
        frame.add(textField3);
        frame.add(new Label());
        frame.add(button);
frame.add(button1);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
