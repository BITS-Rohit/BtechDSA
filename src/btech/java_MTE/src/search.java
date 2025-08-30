public class search {
    public static void main(String[] args){
        int[] ar = {1,2,3,4,5,6,7,8,9,10};
        int  target = 3;
        System.out.println("Searching.. "+ bin(ar,target));
    }
    public static int bin(int[] ar, int target){
        int start = 0;
        int end = ar.length -1;
        int mid = start+ ( end - start )/2;

        while (start<=end){
            if (target < ar[mid]){
                end = mid -1;
            }
            else if (target > ar[mid]){
                start = mid +1;
            }
            else {return mid;}
        }
        return -1;
    }
}
