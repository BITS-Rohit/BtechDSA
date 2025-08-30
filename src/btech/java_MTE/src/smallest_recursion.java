//Write a program in Java to find the smallest element in array using recursion
public class smallest_recursion {
    public static int rec(int[] arr, int n ){
        if (n==1){
            return n;
        }
        return Math.min(arr[n-1], rec(arr , n -1));
    }
    public static void main(String[] args){
        int[] ar = {12,34,5 ,6, 45, 34};
        int n = ar.length;
        System.out.println();
    }
}
