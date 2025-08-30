package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class text_area extends Frame {
    text_area()
    {
        this.setSize(500,500);
        this.setVisible(true);
        this.setTitle("www.textArea.com");
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new FlowLayout());

        Font f = new Font("consolas",Font.BOLD,19);
        Font f1 = new Font("Arial",Font.BOLD,10);

        Label l1 = new Label("Email  Address :-> ",Label.CENTER );
        l1.setFont(f);
        l1.setForeground(Color.BLACK);

        TextArea text = new TextArea("Welcome");
        text.setFont(f1);
        text.setForeground(Color.BLACK);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(l1);add(text);
    }

    public static void main(String[] args) {
        new text_area();
    }

}
