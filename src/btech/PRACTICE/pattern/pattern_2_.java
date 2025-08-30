package JAVA.PRACTICE.pattern;
//Write a program to print following :
//*
//**
//***
//****
//*****

import java.util.Scanner;

import static java.lang.System.in;

public class pattern_2_ {
    public static void main(String[] args){
        Scanner sc = new Scanner(in);
        System.out.println("Enter number : ");
        int num = sc.nextInt();

        for(int i=1; i<=num; i++)
        {
            for (int j =1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
