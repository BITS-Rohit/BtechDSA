package JAVA.exam;

public class _binary_operation {
    public static void main(String[] args){
        int n1 = 23;
        int n2 = 12;
        System.out.println(addition(n1 , n2));
        System.out.println(subtract(n1,n2));
        System.out.println(multiplication(n1,n2));
        System.out.println(division(n1 , n2 ));
    }
    public static int addition(int n1 , int n2){
        return n1+n2;
    }
    public static int subtract (int n1 , int n2){
        return n1 - n2;
    }
    public static int multiplication (int n1 , int n2){
        return n1 * n2;
    }
    public  static int division (int n1 , int n2){
        return n1 / n2;
    }
}
