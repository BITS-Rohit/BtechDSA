package JAVA.PRACTICE.pattern;

import java.util.Scanner;


public  class pattern_1_ {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nth times : ");
        int n= sc.nextInt();
        for(int i=0; i<n;  i++){
            String s="*";
            System.out.println();
            for (int j =0;j< 10;j++){
                System.out.print(s);
            }
        }
    }
}

