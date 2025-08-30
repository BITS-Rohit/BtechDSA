package Btech.class_java.example;

import java.util.Arrays;

public class arrayIndex {
    static void insert(int[] array, int index , int element){
        int[] newArr = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            if (i<index) {
                newArr[i]=array[i];
            }
            if (i==index){
                newArr[i]=element;
                newArr[i+1]=array[i];
            }
            if (i>index){
                newArr[i+1]=array[i];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    static void Insert(int[] array,int index , int element ){
        // array = ( 1,2,4,5 6,7,0)
        for (int i = 0; i < array.length; i++) {
//            for (int j = 1; j <= array.length; j++) {
               if ( i == index ){
                   int temp = array[i];
                   array[i]=element;
                   array[i+1]=temp;
//                   array[i+1]=array[i];

               }
//            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args){
        int[] array =  {1,2,3,4,5,6,8,9};
//        System.out.println("Before insert : "+Arrays.toString(array));
//        System.out.println("After insert : ");
        Insert(array, 2, 3);
    }
}
