package JAVA.PRACTICE.Leetcode;

import java.util.Arrays;

public class TWO_SUM {
    static  int[] twoSum(int[] nums, int target){
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }

            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }

}
class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] arr = new int[n][11];
        int res = 0;
        int l = pick.length;

        for(int i=0;i<l;i++) {
            arr[pick[i][0]] [pick[i][1]]++;
        }

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j] > i) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
