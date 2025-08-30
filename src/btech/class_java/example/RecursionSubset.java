package Btech.class_java.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionSubset {
    static void Subseq(String p , String up){
        if (up.isEmpty()){
//            System.out.print();
            return;
        }
        char ch  = up.charAt(0);
        Subseq(p,up.substring(1));
        Subseq(p+ch,up.substring(1));
    }
    static void SubseqAscii(String p , String up){
        if (up.isEmpty()){
            System.out.print(p);
            return;
        }
        char ch  = up.charAt(0);
        int n= 0;
        Subseq(p,up.substring(1));
        Subseq(p+ch,up.substring(1));
        Subseq(p+(ch+n),up.substring(1));
    }

    static ArrayList<String > PrintSubseqInArrayList(String p , String up){
        if ( up.isEmpty()){
            ArrayList<String> array = new ArrayList<>();
            array.add(p);
            return array;
        }
        char ch = up.charAt(0);
         ArrayList<String> left = PrintSubseqInArrayList(p+ch,up.substring(1));
         ArrayList<String> right = PrintSubseqInArrayList(p,up.substring(1));
         left.addAll(right);
         return left;
    }
    static ArrayList<String > ArraylistAscii(String p , String up){
        if ( up.isEmpty()){
            ArrayList<String> array = new ArrayList<>();
            array.add(p);
            return array;
        }
        char ch = up.charAt(0);
        int n= 0;
         ArrayList<String> first  = ArraylistAscii(p+ch,up.substring(1));
         ArrayList<String> second = ArraylistAscii(p,up.substring(1));
         ArrayList<String> third = ArraylistAscii(p+(ch+n),up.substring(1));
         first.addAll(second);
         first.addAll(third);
         return first;
    }
    static List<List<Integer>> subset (int[] array ){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int num : array){
            int n = list.size();
            for (int i = 0; i <n; i++) {
                List<Integer> inner = new ArrayList<>(list.get(i));
                inner.add(num);
                list.add(inner);
            }
        }
        return list;
    }

    static List<List<Integer>> SubsetDuplicateRemoved (int[] array ){
        Arrays.sort(array);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
            int start =0;
            int end =0 ;
            for (int i = 0; i <array.length; i++) {
                if (i>0 && array[i]==array[i-1]){
                    start = end +1;
                }
                int n = list.size();
                end = list.size()-1;
                for (int j = start; j < n; j++) {
                    List<Integer> inner = new ArrayList<>(list.get(j));
                    inner.add(array[i]);
                    list.add(inner);
                }

            }
        return list;
    }



    //permutation
    static void permutation( String p , String up){
        if ( up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <=p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            permutation(f+ch+s,up.substring(1));
        }
    }

    public static void main(String[] args){
//        Subseq("","abc");

//        System.out.println(PrintSubseqInArrayList("", "abc"));
//        SubseqAscii("","abc");
//        System.out.println(ArraylistAscii("", "abc"));
//        int[] array = {1,2,3};
//        System.out.println(SubsetDuplicateRemoved(array));
//        System.out.println(subset(array));

//        for(List<Integer> list : subset(array)){
//            System.out.println(list);
//        }
//        System.out.println();

        permutation("","abcd");

    }
}
