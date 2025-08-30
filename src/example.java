import java.util.Arrays;

public class example {
    public static void main(String[] args) {
        int[] arr = {12,3,0,2,0,10};
        System.out.println(Arrays.toString(sortZeroOrder(arr)));
    }

    static int[] sortZeroOrder(int[] arr) {
        // Space complexity : O(n);
        // TIme complexity :O(n+n/2  ) = 1.5n = O(n)
        int[] nums = new int[arr.length];
        int j = 0 ;
        int idx=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) j++;
            else nums[idx++]=arr[i];
        }
        for (int i = 0; i < j; i++) {
            arr[idx++]=0;
        }
        return nums;
    }
//    static int[] sortInplace(int[] nums){
//        for (int i = 0; i < nums.length; i++) {
//            if ()
//        }
//    }
}
