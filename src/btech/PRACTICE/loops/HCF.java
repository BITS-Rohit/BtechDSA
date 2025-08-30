package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program to calculate HCF of Two given number.
public class HCF {
    static int hcf=0;
    public static int HCF_num(int n1, int n2){
        for (int i=1;i<= n1||i<n2; i++){
            if (n1%i==0 && n2%i==0) hcf =i;
        }
        return hcf;
    }
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("Enter 1st num : "); int n1 = key.nextInt();
        System.out.println("Enter 2nd num : "); int n2= key.nextInt();
        System.out.println("HCF is : "+HCF_num(n1,n2));
    }
}
