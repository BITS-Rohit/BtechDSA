package JAVA.class_java.tecnique;

public class slidingWindow {
    static int function(int[] arr, int k){
        int maxSum= Integer.MIN_VALUE;
        int sum =0 ;
        for (int i = 0; i < arr.length-k+1; i++) {
            for (int j = 0; j < k; j++) {
                sum+=arr[i+j];
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] ar = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        System.out.println(function(ar,3));
    }

}
