package btech.JAVA_AWT.Project_MAths_java.MAIN_frame;

import btech.JAVA_AWT.Project_MAths_java.Inverse_Trigono.Inverse_trigono;
import btech.JAVA_AWT.Project_MAths_java.Trigono.Tri;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame2 extends Frame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Button click = (Button) e.getSource();
        if (click.getLabel().equals("Trigonometry Values")){
            new Tri();
            this.dispose();
        }
        if (click.getLabel().equals("Inverse Trigonometry")){
            new Inverse_trigono();
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new Frame2();
    }

    Button Trigono,Inverse_Tri;
//    Button Differential,Integration,T_formulas,IT_formulas;
    Label head;
//    Choice c;
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(25,35,340,150);
        g.fillRect(23,33,340,150);
        g.fillRect(27,37,340,150);
    }
    public Frame2(){
        setSize(400,200);
        setVisible(true);
        setTitle("☠  btech.JAVA PROJECT ☠ ️ ️");
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);



        Trigono = new Button("Trigonometry Values");
        Inverse_Tri = new Button("Inverse Trigonometry");

        head = new Label("  btech.JAVA PROJECT  ");


        head.setBounds(110,50,170,50);
        Trigono.setBounds(40,120,140,50);
        Inverse_Tri.setBounds(200,120,140,50);


        Font f2 = new Font("Serif",Font.BOLD,20);
        Font f1 = new Font("Serif",Font.BOLD,11);
        head.setFont(f2);
        Trigono.setFont(f1);
        Inverse_Tri.setFont(f1);


        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\java_Icon.jpg");
        setIconImage(icon);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.add(Trigono);this.add(Inverse_Tri);
        this.add(head);


        Trigono.addActionListener(this);
        Inverse_Tri.addActionListener(this);

//        c= new Choice();
//        c.add("Trigonometry Values");
//        c.add("Inverse Trigonometry");
//        c.setBounds(110,130,170,35);
//        Font f = new Font(null,Font.BOLD,14);
//        c.setFont(f);



//        this.add(c);
//        this.add(Differential);
//        this.add(Integration); this.add(T_formulas); this.add(IT_formulas);



//        Differential.setFont(f1);
//        Integration.setFont(f1);
//        T_formulas.setFont(f1);
//        IT_formulas.setFont(f1);


//        Differential.setBounds(40,220,140,50);
//        Integration.setBounds(200,220,140,50);
//        T_formulas.setBounds(40,300,140,50);
//        IT_formulas.setBounds(200,300,140,50);

//        T_formulas= new Button("Trigonometry Formulas");
//        IT_formulas= new Button("Inverse Trigono Formulas");
//        Differential= new Button("Differentiation Formulas");
//        Integration = new Button("Integration Formulas");


    }
}

