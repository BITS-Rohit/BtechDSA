package Btech.class_java.example;

public class Leet1 {
    static  char smallestLetter(char[] array, char target){
        int start = 0 ;
        int end = array.length-1;

        while (start<= end ){
            int mid  = start - (end - start)/2;
            if (target < array[start]){
                end = mid - 1;
            }
            else start = mid +1;
        }
        return array[start%array.length];
    }
    public int[] buildArray(int[] nums) {
        int[] ans   = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] =nums[nums[i]];
        }

        return ans;
    }
    public static void main(String[] args){
    int[] nums = {0,2,1,5,3,4};
    System.out.println();
    }
}
