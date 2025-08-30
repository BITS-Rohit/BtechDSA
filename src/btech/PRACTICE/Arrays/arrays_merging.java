package JAVA.PRACTICE.Arrays;
//Suppose A, B, C are arrays of integers.
// The numbers in array A appear in ascending order while the numbers in array B appear in descending order.
// Write a user defined method in Java to produce third array C by merging arrays A and B in ascending order.
// Use A, B and C as arguments in the method.
import java.util.ArrayList;
import java.util.Scanner;

public class arrays_merging {
    static  void merging(ArrayList<Integer> a , ArrayList<Integer> b){
       ArrayList<ArrayList<Integer>> c = new ArrayList<>();
//        int[] c = new int[a.length+(b.length*2)];
        c.add(a);
        c.add(b);
        System.out.println(c);
        ArrayList<Integer> n = new ArrayList<>();
        for ( ArrayList<Integer> N: c){
            n.addAll(N);
        }System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        System.out.println(" Enter array 1 size : ");
        int size1 = sc.nextInt();
        System.out.println(" Enter array 2 size : ");
        int size2 = sc.nextInt();

        for (int i=1;i<=size1; i++){
            System.out.println("Enter 1st Array's "+i+" Element : ");
            A.add(sc.nextInt());
        }
        for (int i=1;i<=size2; i++){
            System.out.println("Enter 2nd  Array's "+i+" Element : ");
            B.add(sc.nextInt());
        }
        merging(A,B);
    }
}
//        System.out.println("Enter 1st array size : ");
//        int size1= sc.nextInt();
//        int[] a = new int[size1];
//        for (int i=1;i<=size1; i++)
//        {
//            System.out.println("Enter "+i+" Element :");
//            a[i]= sc.nextInt();
//        }
//        System.out.println("Enter 2nd array size : ");
//        int size2= sc.nextInt();
//        int[] b = new int[size2];
//        for (int i=1;i<=size1; i++)
//        {
//            System.out.println("Enter "+i+" Element :");
//            b[i]= sc.nextInt();
//        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//
//        merging(a, b);