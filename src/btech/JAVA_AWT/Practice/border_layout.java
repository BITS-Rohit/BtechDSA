package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class border_layout extends Frame {
    border_layout(){

        this.setVisible(true);
        this.setSize(500,500);
        this.setBackground(Color.ORANGE);
        this.setForeground(Color.BLACK);
        BorderLayout bl = new BorderLayout(50,50);
        this.setLayout(bl);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Button north = new Button("North");
        Button south = new Button("South");
        Button east = new Button("East");
        Button west = new Button("West");
        Button center = new Button("Center");

        this.add(north,BorderLayout.NORTH);
        this.add(west,BorderLayout.WEST);
        this.add(south,BorderLayout.SOUTH);
        this.add(east,BorderLayout.EAST);
        this.add(center,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new border_layout();
    }
}
