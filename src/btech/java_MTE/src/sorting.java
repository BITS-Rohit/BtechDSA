import java.util.Arrays;

public class sorting {
    public static void PrintArray(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
         int[] arr = { 7,8,3,1,2};
         System.out.println("Array is : "+ Arrays.toString(arr));

         // bubble sort ; Time Complexity : O(n^2)
        for (int i=0;i< arr.length-1; i++){
            for (int j =0;j<arr.length-i-1 ;j++){
                if (arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        System.out.println("Bubble sort: ");
        PrintArray(arr);

        //selection sort; Time complexity : O(n^2)
        for (int i=0;i<arr.length ; i++){
            int smallest = i;
            for (int j =i+1;j<arr.length ;j++)
                if (arr[smallest] >arr[j]){
                    smallest = j;
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i]= temp;
        }
        System.out.println("Selection sort :");
        PrintArray(arr);

        // Insertion sort
        for (int i=0;i<arr.length; i++){
            int current = arr[i];
            int j = i-1;
            while (j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
            }
            //placement
            arr[j+1] = current;
        }
        System.out.println("Insertion sort : ");
        PrintArray(arr);
    }
}
