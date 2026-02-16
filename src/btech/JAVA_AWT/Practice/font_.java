package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class font_ extends Frame {
    font_(){

        this.setVisible(true);
        this.setSize(400,400);
        this.setLayout(null);
        Color c1 = new Color(0x0009270);
        this.setBackground(c1);

        Label l1= new Label("");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Frame f = (Frame)e.getSource();
                f.dispose();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Font f = new Font("Arial", Font.BOLD,25 );
        g.setFont(f);
        g.setColor(Color.white);
        g.fillOval(200,200,40,80);
        g.drawString("Font size guys >>>>",50,50);
    }

    public static void main(String[] args){
        new font_();
    }
}
