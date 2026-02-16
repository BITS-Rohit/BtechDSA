package btech.JAVA_AWT.Calculator;

import java.awt.*;
import java.awt.event.*;

class MAIN_Body extends Frame implements ActionListener {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
Button addition,subtraction,Multiplication,Division, Equal;
Label text;
    MAIN_Body(){
        setSize(400,700);
        setVisible(true);
        setTitle("Calculator");
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        Font f  = new  Font( "Arial Black", Font.BOLD ,20);
        Font f1 = new  Font( "Arial Black", Font.PLAIN,25);
        Font f2 = new  Font( "Arial Black", Font.BOLD ,32);

        text = new Label();
        text.setForeground(Color.BLACK);
        text.setFont(f1);

        b0   = new Button("0");
        b1   = new Button("1");
        b2   = new Button("2");
        b3   = new Button("3");
        b4   = new Button("4");
        b5   = new Button("5");
        b6   = new Button("6");
        b7   = new Button("7");
        b8   = new Button("8");
        b9   = new Button("9");

        addition =       new Button("+");
        subtraction =    new Button("-");
        Multiplication = new Button("*");
        Division =       new Button("/");
        Equal =          new Button("=");

        b0.setFont(f);
        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);
        b5.setFont(f);
        b6.setFont(f);
        b7.setFont(f);
        b8.setFont(f);
        b9.setFont(f);

        addition       .setFont(f2);
        subtraction    .setFont(f2);
        Multiplication .setFont(f2);
        Division       .setFont(f2);
        Equal          .setFont(f);

        b0.setBounds(130,300,130,100);
        b1.setBounds(0,  400,130,100);
        b2.setBounds(130,400,130,100);
        b3.setBounds(260,400,135,100);
        b4.setBounds(0,  500,130,100);
        b5.setBounds(130,500,130,100);
        b6.setBounds(260,500,135,100);
        b7.setBounds(0,  600,130,100);
        b8.setBounds(130,600,130,100);
        b9.setBounds(260,600,135,100);

        b0.setBackground(Color.WHITE);
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.WHITE);
        b5.setBackground(Color.WHITE);
        b6.setBackground(Color.WHITE);
        b7.setBackground(Color.WHITE);
        b8.setBackground(Color.WHITE);
        b9.setBackground(Color.WHITE);

        addition      .setBackground(Color.WHITE);
        subtraction   .setBackground(Color.WHITE);
        Multiplication.setBackground(Color.WHITE);
        Division      .setBackground(Color.WHITE);
        Equal         .setBackground(Color.WHITE);

        addition.setBounds(      0,  200,130,100);
        subtraction.setBounds(   130,200,130,100);
        Multiplication.setBounds(260,200,135,100);
        Division.setBounds(      0,  300,130,100);
        Equal.setBounds(         260,300,135,100);
        text.setBounds(          60, 60 ,270,100);

        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e)
        {System.exit(0);}});

        b1.  addActionListener(this);
        b2.  addActionListener(this);
        b3.  addActionListener(this);
        b4.  addActionListener(this);
        b5.  addActionListener(this);
        b6.  addActionListener(this);
        b7.  addActionListener(this);
        b8.  addActionListener(this);
        b9.  addActionListener(this);

        addition      .addActionListener(this);
        Multiplication.addActionListener(this);
        subtraction   .addActionListener(this);
        b0.addActionListener(this);
        Division      .addActionListener(this);
        Equal.addActionListener(this);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println(e.getComponent());
            }
        });

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(addition);
        this.add(subtraction);
        this.add(Division);
        this.add(Multiplication);
        this.add(b0);
        this.add(Equal);
        this.add(text);

    }
    public static void main(String[] args) {new MAIN_Body();}
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button  clicked= (Button) e.getSource();
        String b_click = clicked.getLabel();
        String event = e.getActionCommand();
        String z,space = null;
        if ("0".equals(event))
        {
//            z=space+text.setText();
        }
        if ("1".equals(event))
        {
            text.setText("1");
        }
        if ("2".equals(event))
        {
            text.setText("2");
        }
        if ("3".equals(event))
        {
            text.setText("3");
        }
        if ("4".equals(event))
        {
            text.setText("4");
        }
        if ("5".equals(event))
        {
            text.setText("5");
        }
        if ("6".equals(event))
        {
            text.setText("6");
        }
        if ("7".equals(event))
        {
            text.setText("7");
        }
        if ("8".equals(event))
        {
            text.setText("8");
        }
        if ("9".equals(event))
        {
            text.setText("9");
        }
        if ("+".equals(event))
        {
            text.setText("+");
        }
        if ("-".equals(event))
        {
            text.setText("-");
        }
        if ("*".equals(event))
        {
            text.setText("*");
        }
        if ("/".equals(event))
        {
            text.setText("/");
        }
        if ("=".equals(event))
        {
            text.setText("=");
        }
    }
}
