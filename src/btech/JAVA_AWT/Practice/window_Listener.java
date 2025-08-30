package btech.JAVA_AWT.Practice;

import java.awt.event.*;

public class window_Listener implements WindowListener, MouseListener, KeyListener {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed ");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified ");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated ");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked at " +e.getPoint());
        System.out.println("%m%.sql.getXOnScreen() : "+e.getXOnScreen());
        System.out.println("Points : "+e.getX()+","+e.getY());
        System.out.println("Get Button : "+e.getButton());
        System.out.println("Get ID"+e.getID());
        System.out.println("is pop up trigger : "+e.isPopupTrigger());
        System.out.println("CLick counter: "+e.getClickCount());
        System.out.println("Location on screen : "+e.getLocationOnScreen());
        System.out.println("Modifiers ex : "+e.getModifiersEx());
        System.out.println("Component : "+e.getComponent());
        System.out.println();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        System.out.println();
        System.out.println("Mouse pressed at " +e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        System.out.println();
        System.out.println("Mouse released at " +e.getPoint());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
        System.out.println();
        System.out.println("Mouse entered at " +e.getPoint());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited"); System.out.println();System.out.println("Mouse exited at " +e.getPoint());
    }

    public static void main(String[] args){
        new window_Listener();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped ---->"+e.getKeyChar());
        System.out.println(e.getComponent());
        System.out.println("Extended key  code : -->"+e.getExtendedKeyCode());
        System.out.println("key code :--->"+e.getKeyCode());
        System.out.println("key location :-->"+e.getKeyLocation());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key  Event " +e.getKeyChar());
        System.out.println();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released"+e.getKeyChar());
        System.out.println();
    }
}
