package JAVA.PRACTICE.Maps;

import java.util.*;

public class MapFunc {
    void fre(int[] nums){
        HashMap< Integer, Integer> m = new HashMap<>();
        freq(nums,m);
    }

    private void freq(int[] nums, HashMap<Integer, Integer> m) {
        for(int num : nums ){
            if (m.containsKey(num)){
                m.put(num,m.get(num)+1);
            }
            else m.put(num,1);
        }
        System.out.println(m.entrySet());
    }

    void firstchar(String str){
        HashMap<Character , Integer> m = new HashMap<>();
        firstchar(str,m);
    }

    private void firstchar(String str, HashMap<Character, Integer> m) {
        for (int i = 0; i <str.length(); i++) {
            char ch = str.charAt(i);

            if ( m.containsKey(ch))m.put(ch,m.get(ch)+1);
            else m.put(ch,1);
        }
        for (char ch : m.keySet()){
            if (m.get(ch)==1) {
                System.out.println(ch);
                return;
            }
        }
    }

    void anagram ( String str , String str2 ){
        if ( str.length()!=str2.length()) return;// return if 2 str lengths are not the same

        HashMap<Character,Integer> m = new HashMap<>(); // map with character

        for(char ch : str.toCharArray()){
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
        for (char ch : str2.toCharArray()) {
            if (!m.containsKey(ch)) {
                System.out.println("False");
                return;
            }
            m.put(ch, m.get(ch) - 1);
        }
        for(int size : m.values()){
            if (size!=0){
                return;
            }
        }
        System.out.println("True");
    }

    //Create a HashMap that maps student names to their marks.
    // Add some entries, and then find the student with the highest marks.
    void High(){
        HashMap<String , Integer> m = new HashMap<>();
        m.put("Student1", 23);
        m.put("Student2", 34);
        m.put("Student3", 1);
        m.put("Student4", 100);
        String ts = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String,Integer> now : m.entrySet()){
            int c = now.getValue();
            if (c>max){
                max=c;
                ts=now.getKey();
            }
        }
        System.out.println(ts);
    }

//Given an array of integers,
// remove all duplicates using a HashMap and return the array with unique values.

    void rev(int[]nums){
        HashMap<Integer,Integer> m = new HashMap<>();
        for( int num : nums){
            if (!m.containsKey(num)){
                m.put(num,1);
            }
        }
        int[] arr = new int[m.size()];
        int size = 0 ;
        for(int num: m.keySet()){
            arr[size]=num;
            size++;
        }
        nums=arr;
        System.out.println(Arrays.toString(nums));
    }
    void subset(int[] nums , int target ){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> outer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target) {
                ArrayList<Integer> inner = new ArrayList<>();
                inner.add(i);
                outer.add(inner);
            }
            for (int j = 1; j < nums.length; j++) {

                if (nums[i]+nums[j]==target){
                    ArrayList<Integer> inner = new ArrayList<>();
                    inner.add(i);
                    inner.add(j);
                    outer.add(inner);
                }
            }
        }
        System.out.println(outer);
    }
    //Group Anagrams:
    //
    //Given an array of strings, group anagrams together using a HashMap.
    //Example: Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
    // Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

    void anagramgrp(String[] strings){
        List<List<String>> outer = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>();
        for ( String str : strings){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String Sorted = new String(ch);
            if (!map.containsKey(Sorted)){
                map.put(Sorted,new ArrayList<>());
            }
            map.get(Sorted).add(str);
        }
        System.out.println(map.values());
    }

    //Given a string,
    //find the length of the longest substring without repeating characters using a HashMap.
    //Example: Input: "abcabcbb" -> Output: 3 (substring is "abc")

    int substring(String s ){
        int maxlen = 0 ;
        int start = 0 ;
        HashMap<Character, Integer> map  = new HashMap<>();
        for (int end = 0; end <s.length(); end++) {

            char ch = s.charAt(end);

            if (map.containsKey(ch)){
                start = Math.max(start,map.get(ch)+1); // updates start index for sliding window
            }
            map.put(ch,end);//update the character index

            maxlen = Math.max(maxlen, end - start + 1 );
        }
        return maxlen;
    }
    boolean followsPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currentPatternChar = pattern.charAt(i);
            String currentWord = words[i];

            // Check if there is a mapping for the pattern character
            if (map.containsKey(currentPatternChar)) {
                // If the current word does not match the mapped word, return false
                if (!map.get(currentPatternChar).equals(currentWord)) {
                    return false;
                }
            } else {
                // If the word is already mapped to a different pattern character, return false
                if (reverseMap.containsKey(currentWord)) {
                    return false;
                }
                // Create a new mapping
                map.put(currentPatternChar, currentWord);
                reverseMap.put(currentWord, currentPatternChar);
            }
        }

        return true;
    }
    void DistinctELEcount(int[] nums , int k ){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        DistinctELEcount(nums,k,map,list);
    }

    private void DistinctELEcount(int[] nums, int k, HashMap<Integer, Integer> map, List<Integer> list) {
        if (k> nums.length) {
            System.out.println(list);
            return;
        }
        map =new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        list.add(map.size());
        DistinctELEcount(Arrays.copyOfRange(nums,1,nums.length),k,map,list);
    }

    //Rearrange the elements of an array in such a way that the most frequent element comes first using a HashMap.
    //Example: Input: [4, 5, 6, 5, 4, 3] -> Output: [5, 5, 4, 4, 6, 3]
    void reaarange(int[] array){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int arr : array){
            map.put(arr,map.getOrDefault(arr,0)+1);
        }
        int i = array.length-1;
        for (Map.Entry<Integer,Integer> now : map.entrySet()){
            for (int j = 0; j < now.getValue(); j++) {
                array[i]= now.getKey();
                i=i-1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    ////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        MapFunc m = new MapFunc();
        int[] ar = {4, 5, 6, 5, 4, 3};
        m.DistinctELEcount(ar,4);
        m.reaarange(ar);
//        m.fre(nums);
//        m.firstchar("swiss");
//        m.anagram("listen","silenr");
//        HashMap<String , Integer> n = new HashMap<>();
//        m.High();
//        int[] nums  ={1,2,2,4,3,3,4,4,4,4,1};
//        m.rev(nums);
//        int[] arr = {2,11,7,15,9};
//        m.subset(arr,9);
//
//        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat" };
//        m.anagramgrp(strings);
//        System.out.println(m.substring("abcdedeabnasmdghash"));
//
//        System.out.println(m.followsPattern("abba","dog cat cat dog"));

    }
}
