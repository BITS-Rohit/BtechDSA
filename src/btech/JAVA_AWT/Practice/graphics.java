package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class graphics extends Frame {
    graphics(){
        this.setVisible(true);
        this.setSize(400,400);
        setTitle("Graphics");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Frame fr;
                fr=(Frame)e.getSource();
                fr.dispose();
            }
        });
    }
    public void paint(Graphics g) {
        g.drawString("⟦⁜⟧ Matrix Calculation",90,275);
        //g.drawRect(95,275,150,25);
        getGraphics().draw3DRect(90,240,150,50,true);
        getGraphics().draw3DRect(50,150,150,50,true);
        g.fillRect(20,20,40,40);
        g.drawOval(100,100,80,50);
        g.fillOval(200,200,20,20);
        g.clipRect(400,400,20,20);
    }
    ////////////////////////////////////////////////////
    public static void main(String[] args) {
        new graphics();
    }
}
