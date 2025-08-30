package JAVA.revision;

public class BSearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 9, 10, 13, 20};
        System.out.println(search(arr));
    }
    static int search ( int[] arr ){
        int s = 0;
        int e = arr.length-1;

        while (s<=e){
            int mid = s+ (e-s)/2;
            if (1 <arr[mid]){
                e=mid-1;
            } else if (1 > arr[mid]) {
                s=mid+1;
            }
            else return mid;
        }
        return -1;
    }
}
