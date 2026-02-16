package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class choice_example2 extends Frame implements ItemListener {
    Choice c;
    Label l1 ;
    choice_example2()
    {
        setSize(500,500);
        setVisible(true);
        setTitle("Choice 2");
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        Font f = new Font("Arial Black",Font.BOLD,15);
        c=new Choice();
        c.setFont(f);
        c.setBounds(200,200,100,80);
        c.setBackground(Color.GREEN);
        c.setForeground(Color.WHITE);

        c.add("N1");
        c.add("N2");
        c.add("N3");
        c.add("N4");
        c.add("N5");

        Font f1 = new Font("Arial Black",Font.BOLD,20);
        l1=new Label();
        l1.setSize(300,200);
        l1.setAlignment(Label.RIGHT);
        l1.setFont(f1);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(c);add(l1);

        c.addItemListener(this);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        l1.setText(" Item --->>> "+c.getSelectedItem());
    }

    public static void main(String[] args) {
        new choice_example2();
    }
}
