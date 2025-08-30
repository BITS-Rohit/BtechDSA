package Btech.class_java.example;

public class SearchElement {
    static int search(int[] array , int target ){
        int start = 0 ;
        int end = array.length-1;

        while ( start <= end ){

            int mid  = start + ( end - start )/2;

            if (target < array[mid]) {
                end = mid -1;
            }
            else if ( target > array[mid]) {
                start = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,4,6,7,8,9,13,15,17};
        System.out.println(search(array,10));
    }
}
