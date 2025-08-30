package rohit.OOPS_DSA;

import java.util.Arrays;

class Merge_Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {1,4,2,56,3,43,0};
        System.out.println(Arrays.toString(merge(arr)));
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static int[] merge(int[] array){
        if(array.length==1){
            return array;
        }
        int mid = array.length/2;

        int[] left = merge(Arrays.copyOfRange(array,0,mid));
        int[] right = merge(Arrays.copyOfRange(array,mid,array.length));
        return SORT(left,right);
    }

    private static int[] SORT(int[] first, int[] second) {
        int[] result = new int[first.length+second.length];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i< first.length && j< second.length){
            if (first[i]<second[j]){
                result[k]=first[i];
                i++;
            }
            else {
                result[k]=second[j];
                j++;
            }
            k++;
        }
        while (j < second.length){
            result[k]=second[j];
            j++;
            k++;
        }
        while (i<first.length){
            result[k]=first[i];
            i++;
            k++;
        }
        return result;
    }

    static void quick(int[] array, int low , int high){
        if (low>=high){
            return;
        }
        int start = low;
        int end = high;

        int mid =array[(low+high)/2];
        while(start<=end){
            while (array[start]<mid){
                start++;
            }
            while (array[end]>mid){
                end--;
            }
            if (start<=end){
                int temp = array[start];
                array[start]=array[end];
                array[end]=temp;
                start++;
                end--;
            }
        }
        quick(array,low,end);
        quick(array,start,high);
    }
}
