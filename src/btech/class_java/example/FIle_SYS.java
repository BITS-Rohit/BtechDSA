package Btech.class_java.example;

import java.io.FileInputStream;
import java.io.IOException;

public class FIle_SYS {
    public static void main(String[] args) throws IOException {
        int i ;
        FileInputStream fin = new FileInputStream("D:\\hello.txt");
        try {
            do {
                i = fin.read();
                if (i != -1)
                    System.out.println((char) i );
            }
            while (i != -1);
        }
        catch (IOException e) {
            System.out.println("Error while reading file");
        }
        try {
            fin.close();
        }catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}
