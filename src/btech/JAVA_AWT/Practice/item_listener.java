package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class item_listener extends Frame implements ItemListener {
    Checkbox ch1,ch2,ch3;
    Label l1;
    item_listener()
    {
        setSize(500,500);
        setVisible(true);
        setTitle("Item Listener");
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        Font f1 = new Font("Serif",Font.BOLD,18);
        l1=new Label();
        l1.setAlignment(Label.CENTER);
        l1.setSize(400,100);
        l1.setFont(f1);

        CheckboxGroup cbg = new CheckboxGroup();
//        l2=new Label();
//        l2.setBounds(100,50,50,50);
//        l2.setSize(200,200);
//        l2.setFont(f1);
//
//        l3=new Label();
//        l3.setBounds(100,250,50,50);
//        l3.setSize(200,200);
//        l3.setFont(f1);
/////////////////////////////////////
        Font f = new Font("consolas",Font.BOLD,12);
/////////////////////////////////////
        ch1 = new Checkbox("Eggs ",cbg,false);
        ch2 = new Checkbox("Knife",cbg,false);
        ch3 = new Checkbox("Drugs",cbg,false);
/////////////////////////////////////
        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
////////////////////////////////////
        ch1.setBackground(Color.white);
        ch2.setBackground(Color.white);
        ch3.setBackground(Color.white);
////////////////////////////////////
        ch1.setBounds(200,150,50,30);
        ch2.setBounds(200,200,50,30);
        ch3.setBounds(200,250,50,30);
////////////////////////////////////
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
////////////////////////////////////
        ch1.addItemListener(this);
        ch2.addItemListener(this);
        ch3.addItemListener(this);
/////////////////////////////////////
        add(l1);add(ch1);add(ch2);add(ch3);
//        add(l2);add(l3);
    }
    @Override
    public void itemStateChanged(ItemEvent e)
    {
//        if(ch1.getState())  l1.setText("Selected Area -> Eggs ");
//        if(ch2.getState())  l1.setText("Selected Area -> Knife");
//        if(ch3.getState())  l1.setText("Selected Area -> Drugs");

        Checkbox ch ;
        ch = (Checkbox) e.getItemSelectable();
        if (ch.getState()) l1.setText(ch.getLabel()+" is Checked");
        else l1.setText(ch.getLabel()+ " is UnChecked");

//        if(ch1.getState())  l1.setText(ch1.getLabel()+" is Checked");
//        else l1.setText(ch1.getLabel()+" is Unchecked");
//        if(ch2.getState())  l2.setText(ch2.getLabel()+" is Checked");
//        else l2.setText(ch2.getLabel()+" is Unchecked");
//        if(ch3.getState())  l3.setText(ch3.getLabel()+" is Checked");
//        else l3.setText(ch3.getLabel()+" is Unchecked");
    }
    public static void main(String[] args) {
        new item_listener();
    }
}
