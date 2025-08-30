package btech.JAVA_AWT.Project_MAths_java.Inverse_Trigono;


import btech.JAVA_AWT.Project_MAths_java.MAIN_frame.Frame2;

import java.awt.*;
import java.awt.event.*;

public class Inverse_trigono extends Frame implements ActionListener, ItemListener {
    Label headline1, Output3, Output4;
    Choice c1;
    Button clear1;
    TextField Input1;
    public Inverse_trigono(){
        setSize(500,325);
        setVisible(true);
        setTitle("Inverse Trigonometry");
        setLayout(null);
        setBackground(Color.WHITE);

        headline1 = new Label("   Inverse Trigonometry values ");
        Output3   = new Label("Output 1");
        Output4   = new Label("Output 2");
        c1        = new Choice();
        clear1    = new Button("Clear");

        Font f  = new Font(null,Font.BOLD,18);
        Font f1 = new Font(null,Font.BOLD,14);

        Output3.setFont(f);
        Output4.setFont(f);
        Input1 = new TextField("Input1 here 1st");
        c1.setFont(f1);
//        calculate = new Button("Calculate");

        headline1.setBounds( 95,25, 315,45 );
        c1.setBounds(        50, 100, 150,50 );
        Input1.setBounds(230,100,120,25);
        Output3.setBounds(  45,155,420,60);
        Output4.setBounds(  45,235,420,60);
//        calculate.setBounds(30, 225,110, 35 );
        clear1.setBounds(    365,90,90,45 );

        Font Head_f = new Font("Serif",  Font.PLAIN,25);
        headline1.setFont(Head_f);
        headline1.setBackground(Color.LIGHT_GRAY);
        Output3.setBackground(Color.LIGHT_GRAY);
        Output4.setBackground(Color.LIGHT_GRAY);
        c1.setBackground(Color.LIGHT_GRAY);

        c1.add("Function");
        c1.add("Inverse Sine X");
        c1.add("Inverse Cosine X");
        c1.add("Inverse Tan X");
        c1.add("Inverse Cosec X");
        c1.add("Inverse Sec X");
        c1.add("Inverse Cot X");
        c1.add("BACK");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        clear1.addActionListener(this);
        c1.addItemListener(this);

        add(c1); add(headline1); add(Output3); add(Output4); add(clear1);add(Input1);
//        add(calculate);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Button click = (Button) e.getSource();
        String  label = click.getLabel();
        if (label.equals("Clear")){
            Input1.setText(" ");
            Output3.setText("Output 1");
            Output4.setText("Output 2");
            c1.select("Function");
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (c1.getSelectedItem().equals("Inverse Sine X")){
            try {
                double z =Double.parseDouble(Input1.getText());
                double sineValue = Math.asin(Math.toRadians(z));
                Output3.setText("Inverse Sin(" + z + ") in Degrees is "+sineValue);
                Output4.setText("Inverse Sin(" + z + ") in Radian is "+Math.asin(z));
            }catch (NumberFormatException c){
                Output3.setText("1st Input1 value then select choice");
            }
        }
        if (c1.getSelectedItem().equals("Inverse Cosine X")){
            try {
                double z =Double.parseDouble(Input1.getText());
                double sineValue = Math.acos(Math.toRadians(z));
                Output3.setText("Inverse Cos(" + z + ") in Degrees is "+sineValue);
                Output4.setText("Inverse Cos(" + z + ") in Radian is "+Math.acos(z));
            }catch (NumberFormatException c){
                Output3.setText("1st Input1 value then select choice");
            }
        }
        if (c1.getSelectedItem().equals("Inverse Tan X")){
            try {
                double z =Double.parseDouble(Input1.getText());
                double tanValue = Math.atan(Math.toRadians(z));
                Output3.setText("Inverse Tan(" + z + ") in Degrees is "+tanValue);
                Output4.setText("Inverse Tan(" + z + ") in Radian is "+Math.atan(z));
            }catch (NumberFormatException c){
                Output3.setText("1st Input1 value then select choice");
            }
        }if (c1.getSelectedItem().equals("Inverse Sec X")){
            try {
                double z =Double.parseDouble(Input1.getText());
                double secValue = (1/Math.acos(Math.toRadians(z)));
                Output3.setText("Inverse Sec(" + z + ") in Degrees is "+secValue);
                Output4.setText("Inverse Sec(" + z + ") in Radian is "+(1/Math.acos(z)));
            }catch (NumberFormatException c){
                Output3.setText("1st Input1 value then select choice");
            }
        }if (c1.getSelectedItem().equals("Inverse Cosec X")){
            try {
                double z =Double.parseDouble(Input1.getText());
                double cosecValue = (1/Math.asin(Math.toRadians(z)));
                Output3.setText("Inverse Cosec(" + z + ") in Degrees is "+cosecValue);
                Output4.setText("Inverse Cosec(" + z + ") in Radian is "+(1/Math.asin(z)));
            }catch (NumberFormatException c){
                Output3.setText("1st Input1 value then select choice");
            }
        }if (c1.getSelectedItem().equals("Inverse Cot X")){
            try {
                double z =Double.parseDouble(Input1.getText());
                double cotValue = 1/Math.atan(Math.toRadians(z));
                Output3.setText("Inverse Cot(" + z + ") in Degrees is "+cotValue);
                Output4.setText("inverse Cot(" + z + ") in Radian is "+(1/Math.atan(z)));
            }catch (NumberFormatException c){
                Output3.setText("1st Input1 value then select choice");
            }
        }
        if (c1.getSelectedItem().equals("BACK")){
            new Frame2();
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new Inverse_trigono();
    }
}
