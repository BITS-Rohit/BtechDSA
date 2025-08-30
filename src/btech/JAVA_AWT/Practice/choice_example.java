package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class choice_example  extends Frame  {
    Choice c;
    choice_example()
    {
        setSize(500,500);
        setVisible(true);
        setTitle("Choice_Example");
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Font f = new Font("Arial Black",Font.BOLD,14);
        c=new Choice();
        c.setFont(f);
        c.setBounds(100,150,100,70);
        c.add("N1");
        c.add("N2");
        c.add("N3");
        c.add("N4");
        c.add("N5");

        add(c);
    }

    public static void main(String[] args) {
        new choice_example();
    }
}
