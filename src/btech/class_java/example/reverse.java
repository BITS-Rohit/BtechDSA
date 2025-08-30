package Btech.class_java.example;

import java.util.Arrays;

public class reverse {
    static void rev(int[] array ){
        System.out.print("[ ");
        for (int i = array.length-1; i >=0 ; i--) {
//            System.out.print(STR."\{array[i]} ");
        }
System.out.print("]");
    }

    //
    static void rev2(int[] array){
        int[] newArr = new int[array.length];
        int j =0;
        for (int i = array.length-1; i >=0 ; i--) {

            newArr[j]=array[i];
            j++;
        }
        System.out.println(Arrays.toString(newArr));
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        rev(array);
        System.out.println();
        rev2(array);
    }
}
