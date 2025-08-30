package btech.JAVA_AWT.Project_MAths_java.Trigono;

import btech.JAVA_AWT.Project_MAths_java.MAIN_frame.Frame2;

import java.awt.*;
import java.awt.event.*;

public class Tri extends Frame implements ActionListener, ItemListener {
    Label headline,Output1,Output2;
    Choice c ;
    Button clear;
    TextField Input;
    public Tri(){
        setSize(500,325);
        setVisible(true);
        setTitle("Trigonometry");
        setLayout(null);
        setBackground(Color.WHITE);

        headline= new Label("   Trigonometry Values ");
        Output1= new Label("Output 1");
        Output2= new Label("Output 2");
        c = new Choice();
        clear= new Button("Clear");

        Font f = new Font(null,Font.BOLD,18);
        Font f1 = new Font(null,Font.BOLD,14);

        Output1.setFont(f);
        Output2.setFont(f);
        Input = new TextField("Input here 1st");
        c.setFont(f1);

        headline.setBounds( 135,25, 225,45 );
        c.setBounds(        50, 100, 150,50 );
        Input.setBounds(230,100,120,25);
        Output1.setBounds(  45,155,420,60);
        Output2.setBounds(  45,235,420,60);
        clear.setBounds(    365,90,90,45 );

        Font Head_f = new Font("Serif",  Font.PLAIN,20);
        headline.setFont(Head_f);
        headline.setBackground(Color.LIGHT_GRAY);
        Output1.setBackground(Color.LIGHT_GRAY);
        Output2.setBackground(Color.LIGHT_GRAY);
        c.setBackground(Color.LIGHT_GRAY);

        c.add("Function");
        c.add("Sine X");
        c.add("Cosine X");
        c.add("Tan X");
        c.add("Cosec X");
        c.add("Sec X");
        c.add("Cot X");
        c.add("BACK");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        clear.addActionListener(this);
        c.addItemListener(this);

        this.add(c); this.add(headline); this.add(Output1); this.add(Output2); this.add(clear); this.add(Input);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Button click = (Button) e.getSource();
        String  label = click.getLabel();
        if (label.equals("Clear")){
            Input.setText(" ");
            Output1.setText("Output 1");
            Output2.setText("Output 2");
            c.select("Function");
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (c.getSelectedItem().equals("Sine X")){
            try {
                double z =Double.parseDouble(Input.getText());
                double sineValue = Math.sin(Math.toRadians(z));
                Output1.setText("Sin(" + z + ") in Degrees is "+sineValue);
                Output2.setText("Sin(" + z + ") in Radian is "+Math.sin(z));
            }catch (NumberFormatException c){
                Output1.setText("1st Input value then select choice");
            }

        }
        if (c.getSelectedItem().equals("Cosine X")){
            try {
                double z =Double.parseDouble(Input.getText());
                double sineValue = Math.sin(Math.toRadians(z));
                Output1.setText("Cos(" + z + ") in Degrees is "+sineValue);
                Output2.setText("Cos(" + z + ") in Radian is "+Math.sin(z));
            }catch (NumberFormatException c){
                Output1.setText("1st Input value then select choice");
            }

        }
        if (c.getSelectedItem().equals("Tan X")){
            try {
                double z =Double.parseDouble(Input.getText());
                double tanValue = Math.tan(Math.toRadians(z));
                Output1.setText("Tan(" + z + ") in Degrees is "+tanValue);
                Output2.setText("Tan(" + z + ") in Radian is "+Math.tan(z));
            }catch (NumberFormatException c){
                Output1.setText("1st Input value then select choice");
            }
        }if (c.getSelectedItem().equals("Sec X")){
            try {
                double z =Double.parseDouble(Input.getText());
                double secValue = (1/Math.cos(Math.toRadians(z)));
                Output1.setText("Sec(" + z + ") in Degrees is "+secValue);
                Output2.setText("Sec(" + z + ") in Radian is "+(1/Math.cos(z)));
            }catch (NumberFormatException c){
                Output1.setText("1st Input value then select choice");
            }
        }if (c.getSelectedItem().equals("Cosec X")){
            try {
                double z =Double.parseDouble(Input.getText());
                double cosecValue = (1/Math.sin(Math.toRadians(z)));
                Output1.setText("Tan(" + z + ") in Degrees is "+cosecValue);
                Output2.setText("Tan(" + z + ") in Radian is "+(1/Math.sin(z)));
            }catch (NumberFormatException c){
                Output1.setText("1st Input value then select choice");
            }
        }if (c.getSelectedItem().equals("Cot X")){
            try {
                double z =Double.parseDouble(Input.getText());
                double cotValue = 1/Math.tan(Math.toRadians(z));
                Output1.setText("Tan(" + z + ") in Degrees is "+cotValue);
                Output2.setText("Tan(" + z + ") in Radian is "+(1/Math.tan(z)));
            }catch (NumberFormatException c){
                Output1.setText("1st Input value then select choice");
            }
        }
        if (c.getSelectedItem().equals("BACK")){
            new Frame2();
            this.dispose();

        }
    }
    public static void main(String[] args) {
        new Tri();
    }
}
