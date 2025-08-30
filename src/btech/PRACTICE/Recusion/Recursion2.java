package JAVA.PRACTICE.Recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion2 {
    public void mindiffsubset(int[] nums){
        boolean[] b = new boolean[nums.length];
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(mindiffsubset(nums,nums[nums.length-1], b,outer,0,0));
    }

    private boolean mindiffsubset(int[] nums, int diff, boolean[] b, List<List<Integer>> outer, int i,int cs) {
        if ( cs == diff || Math.abs(cs-diff)==1|| Math.abs(diff-cs)==1){
            return true;
        }

        if (i== nums.length-1){
            System.out.println(outer);
            return true;
        }

        for (int j = i; j < nums.length; j++) {
            ArrayList<Integer> in = new ArrayList<>();
            if (!b[j] && nums[j]+cs<diff){
                b[j]=true;
                in.add(nums[j]);
                mindiffsubset(nums,diff,b,outer,i+1,cs+nums[j]);
            }
            if (mindiffsubset(nums,diff,b,outer,i+1,cs+nums[j])){
                outer.add(in);
            }
            else {
                b[j] = false;
                in.removeLast();
            }
        }
        return false;
    }
}
