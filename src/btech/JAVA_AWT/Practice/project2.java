package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class project2 extends Frame {
    project2(){
        setSize(600,600);
        setVisible(true);
        setTitle("Changing Frame by buttons!!!");
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Button Red= new Button("Red");
        Red.setBounds(150,50,80,30);
        Red.setBackground(Color.RED);
        Button Blue= new Button("Blue");
        Blue.setBounds(250,50,80,30);
        Blue.setBackground(Color.blue);
        Button Yellow= new Button("Yellow");
        Yellow.setBounds(350,50,80,30);
        Yellow.setBackground(Color.YELLOW);

        Yellow.addActionListener(e-> setBackground(Color.YELLOW));
        Blue.addActionListener(e-> setBackground(Color.BLUE));
        Red.addActionListener(e-> setBackground(Color.RED));

        this.add(Red);
        this.add(Blue);
        this.add(Yellow);
    }

    public static void main(String[] args) {
        new project2();
    }
}
