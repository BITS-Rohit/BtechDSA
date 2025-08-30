package JAVA.PRACTICE.Recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class Recursive {

    int fac(int num){           // Factorial
        if (num == 0){
            return 1;
        }
        return num* fac(num-1);
    }

    void fibo(int num ){                // Fibonacci
        System.out.print("0 1 ");
        fibo(num,0,1);
    }
    private void fibo(int num , int start , int s2){
        if ( num == 1 ){
            return ;
        }
        int sum = start+s2;
        start=s2;
        s2=sum;
        System.out.print(sum+" ");
        fibo(num-1,start,s2);
    }

    int SumArray(int[] nums ) {            // Sum of an array
        return SumArray(nums,0);
    }

    private int SumArray(int[] nums, int length) {
        if ( length==nums.length){
            return 0;
        }

        return nums[length]+SumArray(nums,length+1);
    }

    int SumDigit(int  num ){            // Sum of digits
        if (num==0) return num;
        return num%10 + SumDigit(num/10);
    }

    int power(int base , int exp){                  //power
        if (exp==0) return 1;
        return base*power(base,exp-1);
    }

    String rev( String str , int n){                 // Reverse of a String
        if (n < 0 ){
            return "";
        }
        return str.charAt(n)+rev(str,n-1);
    }

    int GCD(int num , int num2 ) {
        if ( num2==0) return num;
        return GCD(num2, num % num2);
    }

    int[] sort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = sort(Arrays.copyOfRange(arr,0,mid));
        int[] right = sort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] merge = new int[left.length+right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while ( i < left.length && j < right.length){
            if (left[i]<right[j]){
                merge[k]=left[i];
                i++;
            }
            else {
                merge[k] = right[j];
                j++;
            }
            k++;
        }

        while ( i < left.length){
            merge[k]=left[i];
            i++;
            k++;
        }

        while ( j < right.length){
            merge[k] = right[j];
            j++;
            k++;
        }
        return merge;
    }

    void RemoveChar(String str, char ch){
        System.out.println("Before process: "+str);
        String ans = RemoveChar(str,"",ch,0);
        System.out.println("After process : "+ans);
    }

    private String RemoveChar(String up , String p , char ch , int len){
        if (up.length()==len) return p;
        if (up.charAt(len)!=ch){
            p= p+up.charAt(len);
        }
        return RemoveChar(up,p,ch,len+1);
    }

    void RemFruit(String str , String fruit){
        String ans = RemFruit(str,fruit,"");
        System.out.println(ans);
    }

    private String RemFruit(String str , String fruit , String ans){
        if (str.isEmpty()){
            return ans;
        }
        if (str.startsWith(fruit)) return RemFruit(str.substring(fruit.length()),fruit,ans);
        else {
            return RemFruit(str.substring(1),fruit,ans+str.charAt(0));
        }
    }

    void SubSetString(String str){
        ArrayList<String>s = new ArrayList<>();
        subsetstring(str, "", s);
        System.out.println(s);
    }

    private void subsetstring(String up, String p, ArrayList<String> s ) {
        if (up.isEmpty()) {
            if ( p.isEmpty()) s.add(Arrays.toString(new String[]{p}));
            else s.add(p);
            return;
        }
        char ch = up.charAt(0);
        subsetstring(up.substring(1), p + ch,s);
        subsetstring(up.substring(1), p ,s);
    }


    ArrayList<String> sss(String up, String p ) {

        if (up.isEmpty()) {
            ArrayList<String > s = new ArrayList<>();
            if ( p.isEmpty()) s.add(Arrays.toString(new String[]{p}));
            else s.add(p);
            return s;
        }
        char ch = up.charAt(0);

        ArrayList<String> left = sss(up.substring(1), p + ch);
        ArrayList<String> right =  sss(up.substring(1), p );

        left.addAll(right);
        return left;
    }

    void SSAscii(String str ){
        SSAscii(str , "");
    }

    private void SSAscii(String un, String p) {
        if (un.isEmpty()) {
            System.out.print(" "+p);
            return;
        }

        char ch = un.charAt(0);
        SSAscii(un.substring(1),p+ch);
        SSAscii(un.substring(1),p+ (ch+0));
        SSAscii(un.substring(1),p);
//        System.out.println(p);
    }

    List<List<Integer>> subsetIteration(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    List<List<Integer>> subset_int(int[] nums) {
        List<List<Integer>> out  = new ArrayList<>();
        out.add(new ArrayList<>());
        for (int num : nums) {
            int n = out.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> in = new ArrayList<>(out.get(i));
                in.add(num);
                out.add(in);
            }
        }
        return out;
    }

    //Find all subset of a given size
    void GS_subset (int[] array ){
        Arrays.sort(array);
        List<List<Integer>>  out  = new ArrayList<>();
        List<List<Integer>>  out2 = new ArrayList<>();
        out.add(new ArrayList<>());
        int start = 0;
        int end  = 0 ;
        for (int i = start ; i <array.length;i ++) {
            if ( i >0 && array[i]==array[i-1]){
                start=end;
            }
            int n = out.size();
            end = out.size();
            for (int j = start; j < n; j++) {
                List<Integer> in = new ArrayList<>(out.get(j));
                in.add(array[i]);
                if (in.size()==2){
                    out2.add(in);
                }
                out.add(in);
            }
        }
        System.out.println(out2);
    }

    //Input: set = [4, 3, 2, 3, 5, 2, 1], k = 4
    //Output: True (because the set can be partitioned into subsets [5], [1, 4], [2, 3], [2, 3] each with sum 5)

    boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();

        // If total sum is not divisible by k, we cannot partition it
        if (totalSum % k != 0) return false;

        int targetSum = totalSum / k;
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> partitions = new ArrayList<>();

        // Initialize partitions list
        for (int i = 0; i < k; i++) {
            partitions.add(new ArrayList<>());
        }

        Arrays.sort(nums);
        boolean ans = backtrack(nums, k, targetSum, used, partitions, 0, 0);
        System.out.println(partitions);
        return ans;
    }

    private boolean backtrack(int[] nums, int k, int targetSum, boolean[] used, List<List<Integer>> partitions, int index, int currentSum) {
        // If we have created all k subsets and used all elements, we are done
        if (k == 0) {
            return true;
        }

        // If the current subset's sum equals the target, start a new subset
        if (currentSum == targetSum) {
            return backtrack(nums, k - 1, targetSum, used, partitions, 0, 0);
        }

        for (int i = index; i < nums.length; i++) {
            // If the current element is not used and can be included in the current subset
            if (!used[i] && currentSum + nums[i] <= targetSum) {
                used[i] = true;  // Mark the element as used
                partitions.get(k - 1).add(nums[i]);  // Add the element to the current subset

                // Recursively try to complete the current subset
                if (backtrack(nums, k, targetSum, used, partitions, i + 1, currentSum + nums[i])) {
                    return true;
                }

                // Backtrack: undo the addition and unmark the element
                used[i] = false;
                partitions.get(k - 1).remove(partitions.get(k - 1).size() - 1);
            }
        }

        return false;  // Return false if no valid partitioning is found
    }


    List<List<Integer>> subset_intDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>  out  = new ArrayList<>();
        out.add(new ArrayList<>());
        int start = 0;
        int end  = 0 ;
        for (int i = start ; i <nums.length;i ++) {
            if ( i >0 && nums[i]==nums[i-1]){
                start=end;
            }
            int n = out.size();
            end = out.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> in = new ArrayList<>(out.get(j));
                in.add(nums[i]);
                out.add(in);
            }
        }
        return out;
    }

    List<List<Integer>> subsetDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0;
        int end = 0;
        for (int i = start; i < nums.length; i ++) {
            if (i>0 && nums[i]==nums[i-1]){
                start= end+1;
            }
            int n = outer.size();
            end = outer.size()-1;
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

    void NewPer(String given, String ans ){
        if (given.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = given.charAt(0);
        for (int i = 0; i < ans.length() + 1; i++) {
            NewPer(given.substring(1),
                    ans.substring(0,i)+ch+ans.substring(i));
        }
    }

    ArrayList<ArrayList<String>> NewPerArray(String given, String ans ){
        if (given.isEmpty()){
            ArrayList<String> s = new ArrayList<>();
            ArrayList<ArrayList<String>> str = new ArrayList<>();
            s.add(ans);
            str.add(s);
            return str;
        }
        char ch = given.charAt(0);
        ArrayList<ArrayList<String>> first = new ArrayList<>(new ArrayList<>(NewPerArray(given.substring(1), ans + ch)));
//        NewPer(given.substring(1),ans);
        first.addAll(NewPerArray(given.substring(1),ch+ans+ch));
        return first;
    }

    int newPer(String given, String ans ){
        if (given.isEmpty()){
            System.out.println(ans);
            return 1;
        }
        int count = 0 ;
        char ch = given.charAt(0);
        for (int i = 0; i < ans.length() + 1; i++) {
            count+=newPer(given.substring(1),
                    ans.substring(0,i)+ch+ans.substring(i));
        }
        return count;
    }

    int countPer(String given, String ans , int count){
        if (given.isEmpty()){
            System.out.println(ans);
            return count+1;
        }
        char ch = given.charAt(0);
        for (int i = 0; i < ans.length() + 1; i++) {
            count=countPer(given.substring(1), ans.substring(0,i)+ch+ans.substring(i),count);
        }
        return count;
    }

    void sum_subset(int[] nums ){
        int n = 9;
//        System.out.println(sum_subset(nums,n));
        for (ArrayList<Integer> list : sum_subset(nums,n)){
            System.out.println(list);
        }
    }
                //{3,34,4,12,5,2}

    private ArrayList<ArrayList<Integer>> sum_subset(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (target==nums[i]){
                ArrayList<Integer> sub=new ArrayList<>();
                sub.add(nums[i]);
                ans.add(sub);
            }
            if ( target>nums[i]){                   // 9 >3 ? : true

                for (int j = i+1; j < nums.length ; j++)
                {
                    if(nums[j]<target){ // 4<9 ? : true
                        if (nums[i]+nums[j]==target ){    // i = 3 , j = 4 ; 3+4 == 9 ? : false
                            ArrayList<Integer> sub=new ArrayList<>();
                            sub.add(nums[i]);
                            sub.add(nums[j]);
                            ans.add(sub);
                        }
                        else {
                            int k = j+1;
                            while(k< nums.length){
                                if (k<target){
                                if (nums[i]+nums[j]+nums[k]==target){
                                    ArrayList<Integer> sub=new ArrayList<>();
                                    sub.add(nums[i]);
                                    sub.add(nums[j]);
                                    sub.add(nums[k]);
                                    ans.add(sub);
                                }
                                k++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    void sp(int[] nums , int p){             //Subset with a measured product
        List<List<Integer>> part = new ArrayList<>();
        Backtrack(nums,p,part,new boolean[nums.length],1,0,new ArrayList<>());
        System.out.println(part);
    }

    private void Backtrack(int[] nums, int tp, List<List<Integer>> part, boolean[] booleans, int cp, int index, List<Integer> current ) {

        if (cp==tp){
            part.add(new ArrayList<>(current));
            return;
        }

        if ( index>= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            if (!booleans[i] && cp*nums[i]<=tp) {
                current.add(nums[i]);
                booleans[i] = true;
                Backtrack(nums, tp, part, booleans, cp * nums[i], i + 1, current);
                current.remove(current.size()-1);
                booleans[i]=false;

            }
        }

    }

}





