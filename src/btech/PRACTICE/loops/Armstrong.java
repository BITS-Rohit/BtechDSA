package JAVA.PRACTICE.loops;
//Write a program to print out all Armstrong numbers between 1 and 500.
// If sum of cubes of each digit of the number is equal to the number itself,
// then the number is called an Armstrong number.
//For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 )

public class Armstrong {
    public static int cube(int n ){return n*n*n;}
    public static void main(String[] args) {
        int rem1; int rem2;  int rem3;
        for (int i=1;i<=500 ; i++){
            int temp = i;
            rem1 = temp %10;
            temp=temp/10;
            rem2 = temp %10;
            temp=temp/10;
            rem3= temp %10;
            int c1= cube(rem1); int c2 = cube(rem2);int c3 = cube(rem3);
            if (c1 + c2 + c3 == i) {
                System.out.println("Armstrong number is : ");
                System.out.println(i);
            }
        }
    }
}
