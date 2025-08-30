package btech.JAVA_AWT.Practice;
            ////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class login_Project1 extends Frame {
    Font f = new Font("Arial", Font.BOLD,12);
    Font f1 = new Font("Serif", Font.BOLD,12);
    login_Project1(){
        this.setSize(400,400);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("www.Rohit.com");
        this.setBackground(Color.LIGHT_GRAY);
        this.addMouseListener(new window_Listener());
        this.addKeyListener(new window_Listener());
/////////////////////////////////////////////////////////////////////////////////
        Label username = new Label("USERNAME :");
        username.setBounds(60,100,85,30);
        username.setForeground(Color.BLACK);
//        password.setBackground(Color.WHITE);

        Label password = new Label("PASSWORD :",Label.LEFT);
        password.setBounds(60,140,85,30);
        password.setForeground(Color.BLACK);
//        password.setBackground(Color.WHITE);

        TextField  USER =  new TextField();
        USER.setBounds(170,110,140,15);
        Font f1 = new Font("Arial", Font.PLAIN,10);
        USER.setFont(f1);
        USER.setForeground(Color.BLACK);
        String m = Arrays.toString(USER.getActionListeners());

        TextField Pass = new TextField();
        Pass.setBounds(170,140,140,15);
        char c = '*';
        Pass.setEchoChar(c);
        String n = Arrays.toString(Pass.getActionListeners());
//        Pass.setForeground(Color.BLACK);

        Button Login = new Button("LOGIN");
        Login.setBounds(65,210,120,30);

        Login.setFont(f);
        Login.setForeground(Color.DARK_GRAY);
        System.out.println(Login.getLabel());
        System.out.println(Login.getAlignmentX());
        System.out.println(Login.getAlignmentY());

        Button SIGN_Up = new Button("SIGN UP");
        SIGN_Up.setBounds(215,210,120,30);
        SIGN_Up.setFont(f);
        Login.setForeground(Color.DARK_GRAY);

        add(USER); add(Pass);
        add(username); add(password);
        add(Login);  add(SIGN_Up);
        this.addWindowListener(new window_Listener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing");
                Frame fr = (Frame) e.getSource();
                fr.dispose();
            }
        });
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println(e.getComponent());
            }
        });
        if (m.equals("rohitgupta123@gmail.com") && n.equals("root")){

        }
    }
    ////////////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.CYAN);

        g.fillRect(63,207,123,32);     //Bold Button Login
        g.fillRect(67,211,123,32);      //Bold button Login

        g.fillRect(213,207,123,32);     //Bold Button Sign up
        g.fillRect(217,211,123,32);     //Bold Button Sign up

        g.setFont(f1);
        g.setColor(Color.BLACK);
        g.drawString("Login or Sign up Frame",120,300);
        System.out.println("Clip");
        g.getClip();
    }
    public static void main(String[] args) {
        new login_Project1();
    }
}
