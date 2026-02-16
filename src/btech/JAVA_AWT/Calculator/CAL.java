package btech.JAVA_AWT.Calculator;

import java.awt.*;
import java.awt.event.*;

public class CAL extends Frame implements ActionListener {
    Frame f;
    Label l1;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button b_add, b_sub, b_multiplication, b_division, b_mod,b_calc, b_clr, b_pts, b_neg, b_back;
    double xd;
    double num1,num2,check;

    CAL(){
        f= new Frame("MY CALCULATOR");
// INSTANTIATING COMPONENTS
        l1=new Label();
        l1.setBackground(Color.LIGHT_GRAY);
        l1.setBounds(50,50,260,60);


        b1=new Button   ("1");
        b1.setBounds    (50,340,50,50);
        b2=new Button   ("2");
        b2.setBounds    (120,340,50,50);
        b3=new Button   ("3");
        b3.setBounds    (190,340,50,50);
        b4=new Button   ("4");
        b4.setBounds    (50,270,50,50);
        b5=new Button   ("5");
        b5.setBounds    (120,270,50,50);
        b6=new Button   ("6");
        b6.setBounds    (190,270,50,50);
        b7=new Button   ("7");
        b7.setBounds    (50,200,50,50);
        b8=new Button   ("8");
        b8.setBounds    (120,200,50,50);
        b9=new Button   ("9");
        b9.setBounds    (190,200,50,50);
        b0=new Button   ("0");
        b0.setBounds    (120,410,50,50);
        b_neg =new Button ("+/-");
        b_neg.setBounds  (50,410,50,50);
        b_pts =new Button (".");
        b_pts.setBounds  (190,410,50,50);
        b_back =new Button("back");
        b_back.setBounds (120,130,50,50);

        b_add =new Button ("+");
        b_add.setBounds  (260,340,50,50);
        b_sub =new Button ("-");
        b_sub.setBounds  (260,270,50,50);
        b_multiplication =new Button("*");
        b_multiplication.setBounds (260,200,50,50);
        b_division =new Button ("/");
        b_division.setBounds  (260,130,50,50);
        b_mod =new Button ("%");
        b_mod.setBounds  (190,130,50,50);
        b_calc=new Button("=");
        b_calc.setBounds (245,410,65,50);
        b_clr =new Button ("CE");
        b_clr.setBounds  (50,130,65,50);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);

        b_pts.addActionListener (this);
        b_neg.addActionListener (this);
        b_back.addActionListener(this);

        b_add.addActionListener (this);
        b_sub.addActionListener (this);
        b_multiplication.addActionListener(this);
        b_division.addActionListener (this);
        b_mod.addActionListener (this);
        b_calc.addActionListener(this);
        b_clr.addActionListener (this);

        //FOR CLOSING THE WINDOW

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
//ADDING TO FRAME
        f.add(l1);
        f.add(b1); f.add(b2); f.add(b3); f.add(b4); f.add(b5);f.add(b6); f.add(b7); f.add(b8);f.add(b9);f.add(b0);

        f.add(b_add); f.add(b_sub); f.add(b_mod); f.add(b_multiplication); f.add(b_division); f.add(b_mod);f.add(b_calc);

        f.add(b_clr); f.add(b_pts);f.add(b_neg); f.add(b_back);

        f.setSize(360,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("Calculator");
        f.setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String z,zt;
        if(e.getSource()==b1){
            zt=l1.getText();
            z=zt+"1";
            l1.setText(z);
        }
        if(e.getSource()==b2){
            zt=l1.getText();
            z=zt+"2";
            l1.setText(z);
        }
        if(e.getSource()==b3){
            zt=l1.getText();
            z=zt+"3";
            l1.setText(z);
        }
        if(e.getSource()==b4){
            zt=l1.getText();
            z=zt+"4";
            l1.setText(z);
        }
        if(e.getSource()==b5){
            zt=l1.getText();
            z=zt+"5";
            l1.setText(z);
        }
        if(e.getSource()==b6){
            zt=l1.getText();
            z=zt+"6";
            l1.setText(z);
        }
        if(e.getSource()==b7){
            zt=l1.getText();
            z=zt+"7";
            l1.setText(z);
        }
        if(e.getSource()==b8){
            zt=l1.getText();
            z=zt+"8";
            l1.setText(z);
        }if(e.getSource()==b9){
            zt=l1.getText();
            z=zt+"9";
            l1.setText(z);
        }
        if(e.getSource()==b0){
            zt=l1.getText();
            z=zt+"0";
            l1.setText(z);
        }if(e.getSource()== b_pts){
            zt=l1.getText();
            z=zt+".";
            l1.setText(z);
        }
        if(e.getSource()== b_neg){
            zt=l1.getText();
            z=zt+"-";
            l1.setText(z);
        }
        if (e.getSource()== b_back){
            zt=l1.getText();
            try {
                z=zt.substring(0,zt.length()-1);
            }
            catch (StringIndexOutOfBoundsException c){return;}
            l1.setText(z);
        }
        if(e.getSource()== b_add){
            try {
                num1=Double.parseDouble(l1.getText());
            }catch (NumberFormatException c){
                l1.setText("Invalid format");
                return;
            }
            l1.setText("");
            check=1;

        }
        if(e.getSource()== b_sub){
            try {
                num1=Double.parseDouble(l1.getText());
            }catch (NumberFormatException c){
                l1.setText("Invalid format");
                return;
            }
            l1.setText("");
            check=2;

        }
        if(e.getSource()== b_mod){
            try {
                num1=Double.parseDouble(l1.getText());
            }catch (NumberFormatException c){
                l1.setText("Invalid format");
                return;
            }
            l1.setText("");
            check=3;

        }
        if(e.getSource()== b_multiplication){
            try {
                num1=Double.parseDouble(l1.getText());
            }catch (NumberFormatException c){
                l1.setText("Invalid format");
                return;
            }
            l1.setText("");
            check=4;

        }
        if(e.getSource()== b_division){
            try {
                num1=Double.parseDouble(l1.getText());
            }catch (NumberFormatException c){
                l1.setText("Invalid format");
                return;
            }
            l1.setText("");
            check=5;

        }
        if(e.getSource()==b_calc){
            try {
                num2=Double.parseDouble(l1.getText());
            }catch (Exception c){
                l1.setText("Invalid format");
                return;
            }
            l1.setText("");
            check=6;
        }
        if (check==1) {
            xd = num1+num2;
            l1.setText(String.valueOf(xd));
        }
        if (check==2) {
            xd = num1-num2;
            l1.setText(String.valueOf(xd));
        }
        if (check==3) {
            xd = num1%num2;
            l1.setText(String.valueOf(xd));
        }
        if (check==4) {
            xd = num1*num2;
            l1.setText(String.valueOf(xd));
        }
        if (check==5) {
            xd = num1/num2;
            l1.setText(String.valueOf(xd));
        }

        if(e.getSource()== b_clr)
        {
            num1=num2=check=xd=0;
            l1.setText("");
        }
    }

    public static void main(String[] args) {
        new CAL();
    }
}
