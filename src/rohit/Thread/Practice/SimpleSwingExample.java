package rohit.Thread.Practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleSwingExample {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Horny Panel..");

        // Create a JPanel
        JPanel panel = new JPanel();

        // Create a JLabel
        JLabel label = new JLabel("Ur Imagninary Waifu(cuz r single)");

        // Create a JButton
        JButton button = new JButton(" CLick ur Waifu's Ass");

        // Add JLabel and JButton to the JPanel
        panel.add(label);
        panel.add(button);

        // Add the JPanel to the JFrame
        frame.add(panel);

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the JFrame
        frame.setSize(400, 100);

        // Set the JFrame to be visible
        frame.setVisible(true);
    }
}
