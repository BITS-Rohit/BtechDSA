package btech.JAVA_AWT.Project_MAths_java.MAIN_frame;

import btech.JAVA_AWT.Practice.window_Listener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Framework extends Frame  {
    Frame fr;
    Framework(){
        Font f = new Font("consolas",Font.BOLD,12);
        Font f1 = new Font("Arial",Font.BOLD | Font.ITALIC,11);
        Font f2 = new Font(null,Font.BOLD,10);
        Font f3 = new Font(null,Font.ITALIC,10);

        Label l1 = new Label("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        l1.setBounds(155,50,470,5);

        Label l2 = new Label("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        l2.setBounds(190,70,400,5);

        Label message = new Label("HEY YO WASSUP",Label.CENTER);
        message.setBounds(330,90,103,15);
        message.setFont(f);
        message.setForeground(Color.BLACK);

        Label message1 = new Label("It is a java program for Simple Mathematics :))",Label.CENTER);
        message1.setBounds(260,110,248,16);
        message1.setFont(f1);
        message1.setForeground(Color.BLACK);

        Label l3 = new Label("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        l3.setBounds(315,135,140,5);

        Label l4 = new Label("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        l4.setBounds(340,150,85,7);
//        l4.setBackground(Color.GREEN);

        Label l5 = new Label("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        l5.setBounds(350,165,65,8);
//        l5.setBackground(Color.GREEN);

//        Label password  = new Label("USERNAME");
//        password.setBounds(430,270,64,25);
//        password.setFont(f2);
//
//        Label password  = new Label("PASSWORD");
//        password.setBounds(430,300,64,25);
//        password.setFont(f2);
//////////////////////////////////////////////////////////////////////////
        Button Matrix= new Button("⟦ Matrix Calculation ⟧");
        Matrix.setBounds(75,270,135,30);
        Matrix.setFont(f2);
        Matrix.setForeground(Color.BLACK);

        Button Trigonometry = new Button("⟦ Trigonometric value calculator ⟧");
        Trigonometry.setBounds(75,320,200,30);
        Trigonometry.setFont(f2);
        Trigonometry.setForeground(Color.BLACK);

        Button Inverse_Tri = new Button("⟦ Inverse Trigonometric Value Calculator ⟧");
        Inverse_Tri.setBounds(75,370,245,30);
        Inverse_Tri.setFont(f2);
        Inverse_Tri.setForeground(Color.BLACK);

        Button Differential_Formula = new Button("⟦ Differentiation All Formula ⟧");
        Differential_Formula.setBounds(75,420,175,30);
        Differential_Formula.setFont(f2);
        Differential_Formula.setForeground(Color.BLACK);

        Button Integration_Formula = new Button("⟦ Integration All Formula ⟧");
        Integration_Formula.setBounds(75,470,160,30);
        Integration_Formula.setFont(f2);
        Integration_Formula.setForeground(Color.BLACK);

        TextField feedback = new TextField("Write Your feedback here...");
        char c= '$';
        feedback.setFont(f3);
        feedback.setBounds(15,650,775,140);
//        feedback.setEchoChar(c);

        /////////////////////////////////////////////////////////////////////////

//        add(password);
//        add(password);
        add(Differential_Formula,BorderLayout.CENTER);
        add(Integration_Formula);
        add(feedback);
        add(Inverse_Tri);
        add(Trigonometry);
        add(Matrix);
        add(l5);
        add(l4);
        add(l3);
        add(message1);
        add(message);
        add(l1);
        add(l2);
        /////////////////////////////////////~~Frame Work~~////////////////////////////////////
        this.setTitle("btech.JAVA PROJECT");
        this.setSize(800,800);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        this.addWindowListener(new window_Listener());
        this.addKeyListener(new window_Listener());
        this.addMouseListener(new window_Listener());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("Yes"+ e.getPreciseWheelRotation());
                System.out.println(e.getWheelRotation());
            }
        });
        addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e)
            {
                fr = (Frame)e.getSource();
                fr.dispose();
                System.out.println("Window Closing ");
            }
        }
        );
    }
    public static void main(String[] args) {
         new Framework();
    }
}
