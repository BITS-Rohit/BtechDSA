package JAVA.PRACTICE.Arrays;

import java.util.Scanner;

//declare an array of 5 float  number and  sum them
public class float_sum {
    static void sum_method()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array  : ");
        int size = sc.nextInt();
        float sum =0;
        //float[] ar = new float[size];
        for (int i=0;i< size; i++)
        {
            System.out.println("Enter element : ");
            float element = sc.nextFloat();
            sum+=element;
        }
        System.out.println("Sum of "+size +" is :"+sum);
    }
    static float sum (float[] ar )
    {
        float sum = 0;
        for (float Ar : ar)
        {
             sum +=Ar ;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array  : ");
        int length= sc.nextInt();
        float sum =0;
        float[] Ar = new float[length];

        for (int i=0;  i<length;   i++)
        {
            System.out.println("Enter element : ");
            float element = sc.nextFloat();
            Ar[i] = element;
        }
        for (int i=0;  i<length;  i++)
        {
            sum+=Ar[i];
        }
        System.out.println("Sum of "+length +" is :"+sum);
    }
}
