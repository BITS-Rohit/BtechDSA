package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Flow_layout extends Frame {
    Flow_layout(){
        this.setSize(500,500);
        this.setVisible(true);
        this.setTitle("Flow_layout");
        this.setBackground(Color.BLACK);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Button b1= new Button("Button --> 1");
        Button b2= new Button("Button --> 2");
        Button b3= new Button("Button --> 3");
        Button b4= new Button("Button --> 4");
        Button b5= new Button("Button --> 5");
        Button b6= new Button("Button --> 6");
        Button b7= new Button("Button --> 7");
        Button b8= new Button("Button --> 8");
        Button b9= new Button("Button --> 9");

        this.add(b1); this.add(b2); this.add(b3);
        this.add(b4); this.add(b5); this.add(b6);
        this.add(b7); this.add(b8); this.add(b9);

//        this.setLayout(new FlowLayout(FlowLayout.TRAILING,20,15));
//        this.setLayout(new FlowLayout(FlowLayout.LEADING,20,15));
//        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
//        this.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
        this.setLayout(new FlowLayout(FlowLayout.RIGHT,20,15));
    }

    @Override
    public void paint(Graphics g) {
    }

    public static void main(String[] args) {
        new Flow_layout();
    }
}
