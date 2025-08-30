package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayout extends Frame {
    GridLayout(){
        this.setSize(400,400);
        this.setVisible(true);
        this.setTitle("GridLayout");
        this.setBackground(Color.DARK_GRAY);

        Button b1= new Button("1");
        Button b2= new Button("2");
        Button b3= new Button("3");
        Button b4= new Button("4");
        Button b5= new Button("5");
        Button b6= new Button("6");
        Button b7= new Button("7");
        Button b8= new Button("8");
        Button b9= new Button("9");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.add(b1); this.add(b2); this.add(b3);
        this.add(b4); this.add(b5); this.add(b6);
        this.add(b7); this.add(b8); this.add(b9);
        this.setLayout(new java.awt.GridLayout(3,3,20,15));

    }


    public static void main(String[] args) {
        new GridLayout();
    }
}

