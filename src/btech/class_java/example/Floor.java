package Btech.class_java.example;

public class Floor {
    static int floor(int[] array , int target ){

        int start = 0;
        int end = array.length-1;
        while (start <= end ){
            int mid = start + (end - start) / 2;
            if ( target <array[0]) return -1;
            if (target < array[mid]) end = mid -1;
            else if ( target > array[mid]) start = mid+1;
            else return mid;
        }
        return end;
    }
    public static void main(String[] args){
        int[] array = {1,3,5,6,7,9,13,15,16,19,20,22,24,25,27};
        System.out.println(floor(array,0));
    }
}
