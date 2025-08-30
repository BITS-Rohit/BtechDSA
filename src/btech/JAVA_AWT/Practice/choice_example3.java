package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.*;

class choice_example3 extends Frame implements ItemListener, ActionListener {
    Label label;
    Choice c ;
    Button add,remove,remove_all;
    TextField text;
    choice_example3(){
        setSize(700,700);
        setVisible(true);
        setTitle("Choice Adder");
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        Font f = new Font("Arial Black",Font.BOLD,12);
        add= new Button("ADD");
        add.setBounds(180,285,80,40);
        add.setBackground(Color.LIGHT_GRAY);
        add.setFont(f);

        remove= new Button("REMOVE");
        remove.setBounds(280,285,80,40);
        remove.setBackground(Color.LIGHT_GRAY);
        remove.setFont(f);

        remove_all= new Button("REMOVEALL");
        remove_all.setBounds(380,285,100,40);
        remove_all.setBackground(Color.LIGHT_GRAY);
        remove_all.setFont(f);

        Font f3 = new Font(null,Font.BOLD,22);
        label=new Label();
        label.setFont(f3);
        label.setBounds(160,65,280,45);

        Font f1 = new Font("Arial Black",Font.BOLD,14);
        c= new Choice();
        c.setBounds(265,415,90,30);
        c.setForeground(Color.BLACK);
        c.setBackground(Color.WHITE);
        c.setFont(f1);

        Font f2 = new Font("Serif",Font.BOLD,14);
        text =new TextField("Enter Item :) ");
        text.setFont(f2);
        text.setBounds(265,175,120,40);
        text.setBackground(Color.LIGHT_GRAY);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add.addActionListener(this);
        remove.addActionListener(this);
        remove_all.addActionListener(this);

        c.addItemListener(this);

        this.add(label);
        this.add(add);
        this.add(remove);
        this.add(remove_all);
        this.add(text);
        this.add(c);

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
         label.setText("selected item --> "+c.getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String b_Label= e.getActionCommand();
        if(b_Label.equals("ADD")) {
            c.add(text.getText());
            label.setText("Item added  ->"+text.getText());
        }
        if (b_Label.equals("REMOVE")) {
             c.remove(c.getSelectedItem());
             label.setText("Removed Item -->"+c.getSelectedItem());
        }
        if (b_Label.equals("REMOVEALL")) {
             c.removeAll();
             label.setText("👍 All Removed 👍");
        }
    }

    public static void main(String[] args) {
        new choice_example3();
    }
}
