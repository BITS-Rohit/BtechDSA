package Btech.class_java.example;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayRecursion {

    //Q1 : to check an array is sorted using recursion

    static boolean Sorted(int[] arr){
        int[] ar = new int[arr.length];
        System.arraycopy(arr,0,ar,0,arr.length);
        Arrays.sort(arr);
        return Arrays.equals(ar,arr);
    }
    static boolean sortCheck(int[] arr, int index){
        if (index == arr.length-1) return true;
        return arr[index]<arr[index+1] && sortCheck(arr,index+1);
    }

    //Q2 Find a given number in an array using recursion

    static int Search(int[] arr,int num){
         return helper(arr,num,0);
    }
    static void Search2(int[] arr, int num){
        helper2(arr, num, 0);
    }
    static ArrayList<Integer> answer = new ArrayList<>();
    private static void helper2(int[] arr, int num, int index) {
        if ( index == arr.length) return;
        if (arr[index]==num){
            answer.add(index);
        }
        helper2(arr,num,index+1);
    }

    private static int helper(int[] arr, int num, int index){
        if ( index == arr.length-1) return -1;
        if (arr[index]==num){
            return index;
        }

        return helper(arr,num,index+1);
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    static int array (ArrayList<Integer> ar, int target ,int index){
        if ( index==ar.size()) return -1;
        if (ar.get(index) ==target){
            ans.add(index);
        }
        return array(ar,target,index+1);
    }
    static ArrayList<Integer> find(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if ( index ==arr.length){
            return list;
        }
        if ( arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  find(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }


    public static void main(String[] args){
        int[] arr = {1,2,10,4,10,5};
//        System.out.println(sortCheck(arr,0));
//        System.out.println(Arrays.toString(arr));

        /////////////////
//        System.out.println(STR."Search 1 : \{Search(arr, 10)}");
//
//        Search2(arr,10);
//        System.out.println(answer);

        ////////////////
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(12);
        ar.add(1);
        ar.add(14); //2
        ar.add(100);
        ar.add(14); //4
        ar.add(200);
        ar.add(14); //6
        array(ar,14,0);
        System.out.println("Answer : "+ans);

        System.out.println(find(arr,10,0));

    }
}
