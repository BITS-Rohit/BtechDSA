package Btech.class_java.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TEST2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("\n"+"THIS PROGRAM IS FOR TAKING UR STRING AND SPLITTING IT IN WORDS AND THEN PRINT IT");
        System.out.println("Give me a string or for EXIT type E : ");
        do {
            str = br.readLine();
            System.out.println("STRING IS : " + str+"\n");
            for (String s : str.split(" ")) {
                System.out.println(s);
            }
            System.out.println("\n"+"Give me a string or for EXIT type E : ");
        }
        while (!str.equals("E"));
    }
    student s = new student();
    student s2 = s;
    Integer e =3;


}
class student{
    int rno;
    String name;
    int marks;

    student(){
        System.out.println("Hey yo whatsuppp ");
    }
    student(int val , String name, int marks){
        this.rno=val;
        this.name = name;
        this.marks=marks;
    }
}