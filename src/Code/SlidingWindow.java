package Code;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    static int characterReplacement(String str, int k) {
        int start = 0, maxcount = 0, maxl = Integer.MIN_VALUE;
        int[] count = new int[26];
        for (int end = 0; end < str.length(); end++) {
            int i = count[str.charAt(end) - 'A'];
            i++;
            maxcount = Math.max(i, maxcount);
            if ((end - start + 1) - maxcount > k) {
                count[str.charAt(start) - 'A']--;
                start++;
            }
            maxl = Math.max(maxl, end - start + 1);
        }
        return maxl;
    }

    static int[] MaximumArr(int[] arr, int size) {
        int[] newArr = new int[arr.length - size + 1];
        for (int i = 0; i <= arr.length - size; i++) {
            int j = i, max = arr[j];
            for (j = i + 1; j < i + size; j++) {
                max = Math.max(max, arr[j]);
            }
            newArr[i] = max;
        }
        return newArr;
    }

    static String MinWinString(String str, String p) {
        int[] main = new int[128];
        int[] pattern = new int[128];

        for (char ch : p.toCharArray()) {
            pattern[ch]++;
        }

        int left = 0, right = 0, l = 0, start = 0, min = Integer.MAX_VALUE;
        while (right < str.length()) {
            main[str.charAt(right)]++;
            if (pattern[str.charAt(right)] > 0 && main[str.charAt(right)] <= pattern[str.charAt(right)]) l++;

            while (l == p.length()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                main[str.charAt(left)]--;
                if (pattern[str.charAt(left)] > 0 && main[str.charAt(left)] < pattern[str.charAt(left)]) l--;
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : str.substring(start, start + min);
    }

    static int longeststring(String string) {
        if (string.isEmpty() || string.length() == 1) return 0;
        int[] arr = new int[128];
        int left = 0, right = 0, maxl = Integer.MIN_VALUE;
        while (right < string.length()) {
            char rchar = string.charAt(right);
            if (arr[rchar] > 0) {
                arr[rchar]--;
                left = string.indexOf(rchar, left);

            } else {
                arr[rchar]++;
                maxl = Math.max(maxl, right - left + 1);
                right++;
            }
        }
        return maxl;
    }

    //    static boolean permutation(String s1 , String s2){
//        if (s1.length()==1 && s2.length()==1) return s1.indexOf(s2.charAt(0)) != -1;
//        else if (s1.length()>s2.length()) return false;
//        else {
//            int[] array = new int[26];   // as we know every letter is in lower case
//            for(char ch :s1.toCharArray()){
//                array[ch-'a']++;
//            }
//            for (int i = 0; i < s2.length(); i++) {
//                if (array[s2.charAt(i)]>0){
//                    int j = i ;
//                    while(j<)
//                }
//            }
//        }
//        return false;
//    }
    static public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, MaxSum = 0;
        Set<Integer> set = new HashSet<>(k);
        for (int i = 0; i <= nums.length - k; i++) {
            if (sum == 0) {
                set.clear();
                for (int j = i; j < i + k; j++) {
                    if (!set.contains(nums[j])) {
                        set.add(nums[j]);
                        sum += nums[j];
                    } else {
                        sum = 0;
                        break;
                    }
                }
            } else {
                set.remove((nums[i - 1]));
                if (!set.contains(nums[i + k - 1])) {
                    set.add(nums[i + k - 1]);
                    sum = sum - nums[i - 1] + nums[i + k - 1];
                } else sum = 0;
            }
            MaxSum = Math.max(MaxSum, sum);
        }
        return MaxSum;
    }


    public static void main(String[] args) {
        System.out.println();
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
//        System.out.println(permutation("ab","eidbaooo"));
//        System.out.println(permutation("ab","eidboaoo"));
//        System.out.println(longeststring("abcabcbb"));
//        System.out.println(longeststring("bbbbb"));
//        System.out.println(longeststring("pwwkew"));
//        System.out.println(longeststring("tmmzuxt"));
//        System.out.println(MinWinString("ABSKDJJAKDJABAOC","ABC"));
//        System.out.println(Arrays.toString(MaximumArr(new int[]{1, 3, 1, 2, 5, 3, 6, 7}, 3)));
//        System.out.println(characterReplacement("AABABBA",1));
    }
}
