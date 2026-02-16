package btech.DSA;

import java.util.*;

public class SlidingWIndow {

    static void Swindow(int[] array , int k){
        int[] A2 = new int[array.length-k];
        for (int i = 0; i <= array.length-k-1; i++) {
            A2[i]=getMax(array,i,i+k);
        }
        System.out.println(Arrays.toString(A2));
    }
    // ^
    // |
    // |
    private static int getMax(int[] array, int start, int end) {
        int Max=array[start++];
        while(start<end){
            Max=Math.max(Max,array[start]);
            start++;
        }
        return Max;
    }

    static String MinWinSub(String string, String pattern){
        String s = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < string.length(); i++) {
            int pLen = 0;
            StringBuilder current = new StringBuilder();
            boolean[] bool = new boolean[pattern.length()];
            for (int j = i; j < string.length(); j++) {
                if (isCharofP(string.charAt(j),pattern,bool))pLen++;
                current.append(string.charAt(j));
                if (pLen==pattern.length()){
                    if (current.length() < min) {
                        min = current.length();
                        s = current.toString();
                    }
                    break;
                }
            }
        }
        return s;
    }
    // ^
    // |
    // |
    private static boolean isCharofP(char c,String pattern, boolean[] bool) {
        for (int i = 0; i < pattern.length(); i++) {
            if (c==pattern.charAt(i) && !bool[i]){
                bool[i]=true;
                return true;
            }
        }
        return false;
    }

    static String NewMinSub(String s, String pattern){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);   // Every char in Pattern is now set on Map
        }
        int[] valuesIDX=new int[s.length()];  //for Optimized Location Searching
        int idx=0;
        int idx2=valuesIDX.length-1;
        int MinLength =Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>0) valuesIDX[idx++]=i;
            else valuesIDX[idx2--]=-1;
        }
        //now assumming that valuesIDX starting elements where the actual pattern value exists
        StringBuilder str = new StringBuilder();
        int Min=Integer.MAX_VALUE;
        int S = 0;
        int E = 0;
        for (int i = 0; i < idx- pattern.length(); i++) {
            int end =i+pattern.length();
            if (isString(map, i,end,valuesIDX,pattern)){
                if (i==0){
                    S= valuesIDX[i];
                    E=valuesIDX[end-1];
                }
                else if(valuesIDX[E]-valuesIDX[S] > valuesIDX[i]-valuesIDX[end-1]){
                    S= valuesIDX[i];
                    E=valuesIDX[end-1];
                }
            }
        }
        for (int i = valuesIDX[S]; i <= valuesIDX[E]; i++) {
            str.append(i);
        }
        return String.valueOf(str);
    }

    private static boolean isString(HashMap<Character, Integer> map, int start, int end,int[] array,String pattern) {
        while(start<end){
            if (!map.containsKey(pattern.charAt(array[start]))) return false;
            start++;
        }
        return true;
    }


    ////boolean check = false;
    //        //            for (int j = valuesIDX[i]; j <=valuesIDX[i]+pattern.length()-1; j++) {
    //        //                if (map.containsKey(s.charAt(j)))check=true;
    //        //                else check=false;
    //        //            }
    //        //            if(check){  // if check is true means we have found a valid string
    //        //
    //        //            }
    static String LongUniqueSub(String string){
        StringBuilder str = new StringBuilder();
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < string.length(); i++) {
            if (str.indexOf(String.valueOf(string.charAt(i)),0)==-1)str.append(string.charAt(i));
            else {
                Max=Math.max(Max,str.length());
                int idx = str.indexOf(String.valueOf(string.charAt(i)),0);
                if (idx>0)str.delete(0,idx+1);
                else str.deleteCharAt(str.indexOf(String.valueOf(string.charAt(i))));
//                for (int j = 0; j < idx; j++) {
//                    str.deleteCharAt(j);
//                }
                str.append(string.charAt(i));
            }
        }
        System.out.println(Max);
        return String.valueOf(str);
    }

    static String SlidingWindow(String string, String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, Counter = 0;
        int[] ans = {-1, 0, 0};
        HashMap<Character, Integer> windowMap = new HashMap<>();

        while (right < string.length()) {
            char ch = string.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            if (map.containsKey(ch) && windowMap.getOrDefault(ch, 0).intValue() == map.get(ch).intValue()) Counter++;
            while (left <= right && Counter == map.size()) {
                ch = string.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowMap.put(ch, windowMap.get(ch) - 1);
                if (map.containsKey(ch) && windowMap.get(ch) < map.get(ch)) {
                    Counter--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : string.substring(ans[1], ans[2] + 1);
    }
    static String EffectiveSliding(String str , String pattern){
        if (str.isEmpty() || pattern.isEmpty()) return "";
        int[] pc = new int[128];
        for(char ch : pattern.toCharArray()){
            pc[ch]++;
        }
        int left = 0 , right = 0 , MiniSize = Integer.MAX_VALUE,start= 0 , count = 0;
        int[] wc = new int[128];
        while(right<str.length()){
            char ch = str.charAt(right);
            wc[ch]++;
            if (pc[ch]>0 && wc[ch]==pc[ch])count++;
            while(count == pattern.length()){
                if (right-left+1<MiniSize){
                    MiniSize=right-left+1;
                    start=left;
                }
                ch = str.charAt(left);
                wc[ch]--;
                if (pc[ch]>0 && wc[ch]<pc[ch]){
                    count--;
                }
                left++;
            }
            right++;
        }
        return MiniSize==Integer.MAX_VALUE ? "" : str.substring(start,start+MiniSize);
    }

    static List<List<Integer>> Combination(int n , int k ){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>(k);
        comb(n,k,list,1,inner);
        return list;
    }

    private static void comb(int n, int k, List<List<Integer>> list, int idx, List<Integer> inner) {
        if (inner.size()==k){
            list.add(new ArrayList<>(inner));
            return;
        }
        for (int i = idx; i <= n-(k-inner.size())+1; i++) {
            inner.add(i);
            comb(n,k,list,i+1,inner);
            inner.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(Combination(4,3));
        Vector<Integer> vc = new Vector<>();

//        System.out.println(LongUniqueSub("pwwkew"));
//        System.out.println(LongUniqueSub("abcabcbb"));
//        StringBuilder st = new StringBuilder("pwke");
//        System.out.println("W: "+st.indexOf("w"));
//        st.delete(0,1);
//        System.out.println(st);
//        System.out.println(SlidingWindow("ADOBECODEBANC","ABC"));
//        System.out.println(SlidingWindow("BBAA","ABA"));

//        System.out.print("(3,3,5,5,6): ");
//        Swindow(new int[]{1,3,1,2,5,3,6,7},3);
    }
}

/////------------------------------------------------------------------------

    //Sliding Window Maximum

/////------------------------------------------------------------------------