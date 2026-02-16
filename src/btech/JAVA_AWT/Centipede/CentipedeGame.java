package btech.JAVA_AWT.Centipede;

import javax.swing.*;

public class CentipedeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Centipede Follower");
        CentipedePanel panel = new CentipedePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(panel);
        frame.setVisible(true);
    }
}
