import java.util.Arrays;

// Write a Java program to replace a specific element with another element in array each time.
public class replace_ele {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int old = 5;
        int new_num = 50;
        System.out.println("Before change : "+ Arrays.toString(arr));
        for (int i=0;i<arr.length;i++){
            if ( arr[i] == old){
                arr[i] = new_num;
            }
        }
        System.out.println("After change : "+ Arrays.toString(arr));
    }
}
