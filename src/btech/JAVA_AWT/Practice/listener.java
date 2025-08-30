package btech.JAVA_AWT.Practice;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class listener extends Frame implements WindowListener {

listener(){
    this.setSize(800,800);
    this.setVisible(true);
    this.setTitle("The");
    this.setLayout(null);
    this.addWindowListener(this);
    //this.setAlwaysOnTop(true);
}

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
    dispose();
    }


    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new listener();
    }
}
