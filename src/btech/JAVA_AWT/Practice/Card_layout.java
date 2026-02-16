package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Card_layout  extends Frame implements ActionListener
{
    CardLayout card;
    Button b1,b2,b3,b4;
    Card_layout(){
        this.setSize(500,500);
        this.setVisible(true);
        this.setTitle("Card Layout");
        this.setBackground(Color.DARK_GRAY);
        card =  new CardLayout();
        this.setLayout(card);
        Font f = new Font("Serif",Font.BOLD,15);

        b1= new Button("⟦ Matrix Calculation ⟧");
        b2= new Button("⟦ Trigonometric value calculator ⟧");
        b3= new Button("⟦ Inverse Trigonometric Value Calculator ⟧");
        b4= new Button("⟦ Differentiation All Formula ⟧");

        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);

        b1.setBackground(Color.CYAN);
        b2.setBackground(Color.YELLOW);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.RED);

        //////Registering the buttons to Action listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.add(b1);this.add(b2);this.add(b3);this.add(b4);
    }
    @Override
    public void actionPerformed(ActionEvent e) {card.next(this);}
    public static void main(String[] args) {
        new Card_layout();
    }
    //        b1.setBounds(100,150,150,35);
    //        b2.setBounds(150,150,150,35);
    //        b3.setBounds(200,150,150,35);
    //        b4.setBounds(250,150,150,35);
}
