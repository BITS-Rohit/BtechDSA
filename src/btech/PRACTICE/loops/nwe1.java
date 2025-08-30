package JAVA.PRACTICE.loops;

import java.awt.GraphicsEnvironment;

public class nwe1 {

    public static void main(String[] args) {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts) {
            System.out.println(font);
        }
    }

}