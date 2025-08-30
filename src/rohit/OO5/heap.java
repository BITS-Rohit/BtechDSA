package rohit.OO5;

public class heap {
    public static void main(String[] args) {

    }
    static void heapify(int[] arr , int n , int i ){
        int largest = i ;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left <n && arr[left]>arr[largest]){
            largest=left;
        }
        if (right<n&& arr[left]> arr[largest]){
            largest= right;
        }
        if (largest!=i){
            int swap = arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(arr,n,largest);
        }
    }
}
