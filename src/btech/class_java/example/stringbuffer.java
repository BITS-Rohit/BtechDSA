package Btech.class_java.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stringbuffer {
    public static void main(String[] args)throws IOException {
        char c ;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
         System.out.println("Enter characters or press E to terminate :  ");
         do {
             c = (char)br.read();
             System.out.println(" Char is : "+ c );
         }
         while (c!= 'E');
    }
}
