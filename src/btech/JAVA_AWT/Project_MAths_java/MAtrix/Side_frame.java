package btech.JAVA_AWT.Project_MAths_java.MAtrix;

import java.awt.*;
import java.awt.event.*;

public class Side_frame extends Frame implements ActionListener, ItemListener {

    //    Frame f ;
    Label headline,output;
    TextField Input1,Input2,In4,In5;
    Button b_equal;
    int row=0 , column=0;
//    TextField
    int[][] array;
    Choice c;
    Font Head_f = new Font("consolas",  Font.PLAIN,25);
    Font Output_f = new Font("consolas",Font.PLAIN,15);
    Font Input_f= new Font("consolas",Font.BOLD,10);
    Side_frame(){
        this.setSize(600,366);
        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Matrix Calculation");
        this.setBackground(Color.WHITE);

        headline = new Label("      ⟦ Matrix Calculation ⟧");
        headline.setBounds(130,30,330,75);
        headline.setBackground(Color.LIGHT_GRAY);
        headline.setFont(Head_f);

        c = new Choice();
        c.setBounds(35,125,230,125);
        c.setBackground(Color.LIGHT_GRAY);
        c.add(" ");
        c.add("Set Dimensions to Matrix");
        c.add("Input Values to Matrix");
        c.add("Row-wise Sum to Matrix");
        c.add("Column-wise Sum to Matrix");
        c.add("Total Values Sum to Matrix");
        c.add("Display Matrix");

        output= new Label("Output here");
        output.setBounds(300,130,255,210);
        output.setBackground(Color.LIGHT_GRAY);
        output.setFont(Output_f);

        Input1= new TextField();
        Input2= new TextField();
        In4=new TextField();
        In5=new TextField();
        b_equal = new Button("=");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Input1.addActionListener(this);
        Input2.addActionListener(this);
        c.addItemListener(this);


        this.add(headline); this.add(output);
        this.add(c);this.add(In4);this.add(In5);
        this.add(Input1);
        this.add(Input2);
        this.add(b_equal);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if (event.equals("=")){
            array=new int[row][column];
            for (int i=0;i<row ; i++){

                for (int j=0;j< column; j++){
                    output.setText("Enter "+(i+1)+" row's");
                }
            }
        }

    }
    public static void main(String[] args) {
        new Side_frame();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String z, zt;
        if (c.getItem(1).equals("Set Dimensions to Matrix")){

            Input1.setText("row");
            Input1.setBounds(35,170,60,30);
            Input1.setBackground(Color.LIGHT_GRAY);
            Input1.setFont(Input_f);

            Input2.setText("column");
            Input2.setBounds(125,170,60,30);
            Input2.setBackground(Color.LIGHT_GRAY);
            Input2.setFont(Input_f);

            b_equal.setBounds(35,220,100,20);
            b_equal.setBackground(Color.LIGHT_GRAY);
            Font f = new Font(null,Font.BOLD,20);
            b_equal.setFont(f);

            Input1.setVisible(true);
            Input2.setVisible(true);
            In4.setVisible(false);
            In5.setVisible(false);
            b_equal.addActionListener(e1 -> {
                if (b_equal.isEnabled()){
                    try{
                        row=Integer.parseInt(Input1.getText());
                        column =Integer.parseInt(Input2.getText());

                        Font f1 = new Font(null,Font.BOLD,20);
                        output.setText("Done");
                        output.setFont(f1);
                    }
                    catch (NumberFormatException c) {
                        output.setText("try again");
                    }
                }
            });

        }
        if (c.getItem(2).equals("Input Values to Matrix")) {
            Input1.setVisible(false);
            Input2.setVisible(false);

            In4.setText("Elements");
            In4.setBounds(35,170,60,30);
            In4.setBackground(Color.LIGHT_GRAY);
            In4.setFont(Input_f);


            In5.setText("Elements");
            In5.setBounds(125,170,60,30);
            In5.setBackground(Color.LIGHT_GRAY);
            In5.setFont(Input_f);

        }
        if (c.getItem(3).equals("Row-wise Sum to Matrix")){

        }
        if (c.getItem(4).equals("Column-wise Sum to Matrix")){

        }
        if (c.getItem(5).equals("Total Values Sum to Matrix")){

        }
        if (c.getItem(6).equals("Display Matrix")){
            for (int[] in : array) {
                for (int anInt : in) {
                    output.setText(anInt + " ");
                }
                System.out.println();
            }
        }

    }
}