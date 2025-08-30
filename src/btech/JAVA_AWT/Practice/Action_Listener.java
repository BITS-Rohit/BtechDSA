package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Action_Listener extends Frame implements ActionListener {

    Action_Listener(){
        this.setSize(500,500);
        this.setVisible(true);
        this.setTitle("Flow_layout");
        this.setBackground(Color.DARK_GRAY);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Label l1 = new Label("");
        l1.setBounds(50,50,150,50);
        Label l2 = new Label("");
        Font f = new Font("Serif",Font.BOLD,12);

        Button b1= new Button("Project");
        b1.setForeground(Color.white);
        b1.setBounds(150,150,50,20);
        Button b2= new Button("@ Project @");
        b2.setBounds(150,250,100,20);
        b2.setForeground(Color.white);

        b1.setFont(f); b2.setFont(f);
        b2.addActionListener(e -> {
            l2.setText("This is inside action performed in 2nd Button");
            l2.setBounds(150,200,350,20);
            Font f1 = new Font("Arial",Font.BOLD,16);
            l2.setFont(f1);
            l2.setForeground(Color.cyan);
        });
        b1.addActionListener(e -> {
            l1.setText("Welcome to Project");
            Font f1 = new Font("Arial",Font.BOLD,16);
            l1.setFont(f1);
        }
        );

        this.add(b1); this.add(b2); this.add(l1); this.add(l2);
    }

    public static void main(String[] args) {
        new Action_Listener();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ACTION COMMAND :--> "+e.getActionCommand());
    }
}
