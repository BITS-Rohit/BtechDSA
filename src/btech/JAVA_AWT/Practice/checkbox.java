package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class checkbox extends Frame implements ActionListener {
    checkbox(){
        setSize(500,500);
        setVisible(true);
        setTitle("checkbox");
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        Font f = new Font("consolas",Font.BOLD,14);

        Checkbox ch1 = new Checkbox("Eggs");
        Checkbox ch2 = new Checkbox("Knife");
        Checkbox ch3 = new Checkbox("Drugs");

        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);

        ch1.setBackground(Color.white);
        ch2.setBackground(Color.white);
        ch3.setBackground(Color.white);

        ch1.setBounds(100,100,50,30);
        ch2.setBounds(100,150,50,30);
        ch3.setBounds(100,200,50,30);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(ch1);add(ch2);add(ch3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}

    public static void main(String[] args) {
        new checkbox();
    }
}
