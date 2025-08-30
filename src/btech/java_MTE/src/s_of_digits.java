import java.util.Scanner;

public class s_of_digits {
    public static int sumOfDigit(int n ){
        if (n>=0 && n<=9){
            return n;
        }
        return sumOfDigit(n/10) + n%10;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Sum of digits of "+n+" is: ");
        System.out.println(sumOfDigit(n));

    }
}
