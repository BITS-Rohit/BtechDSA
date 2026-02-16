package Code;

// For the 1-Based Indexing
// Parent = i/2
// left child = 2 * i
// right child = 2 * i + 1

// For the 0-Based Indexing
// Parent = (i-1)/2
// left child = 2 * i +1
// right child = 2 * i + 2


import java.util.Arrays;

class Min_Heap {
    private final int[] array = new int[10];
    private int idx = 1;

    Min_Heap() {
        Arrays.fill(array, Integer.MIN_VALUE);
    }

    void insert(int num) {
    if (idx == array.length) {
        throw new IllegalStateException("Heap is full");
    }
    array[idx] = num;
    int current = idx;
    idx++;

    // Heapify up
    while (current > 1 && array[current] < array[current / 2]) {
        int temp = array[current];
        array[current] = array[current / 2];
        array[current / 2] = temp;
        current = current / 2;
    }
}


    int delete() {
        int temp = array[1];
        idx--;
        array[1] = array[idx];
        array[idx] = Integer.MIN_VALUE;
        for (int i = 1; i < idx / 2; i++) {
            if (array[2 * i] != Integer.MIN_VALUE && array[2 * i + 1] != Integer.MIN_VALUE) {
                if (array[2 * i] < array[2 * i + 1]) {
                    int t = array[i];
                    array[i] = array[2 * i];
                    array[2 * i] = t;
                } else {
                    int t = array[2 * i + 1];
                    array[i] = array[2 * i + 1];
                    array[2 * i + 1] = t;
                }
            } else if (array[2 * i] != Integer.MIN_VALUE && array[2 * i + 1] == Integer.MIN_VALUE) {
                if (array[2 * i] < array[i]) {
                    int t = array[i];
                    array[i] = array[2 * i];
                    array[2 * i] = t;
                }
            } else if (array[2 * i] == Integer.MIN_VALUE && array[2 * i + 1] != Integer.MIN_VALUE) {
                if (array[2 * i + 1] < array[i]) {
                    int t = array[i];
                    array[i] = array[2 * i + 1];
                    array[2 * i + 1] = t;
                }
            }
        }
        return temp;
    }

    int[] HeapSort() {
        int i = idx - 1;
        int[] arr = new int[i - 1];
        while (i > 0) {
            arr[i - 1] = delete();
            i--;
        }
        return arr;
    }

    void print(){
        int i = idx-1;
        int[] arr = new int[i-1];
        while (i > 0) {
            arr[i - 1] = array[i];
            i--;
        }
        System.out.println(Arrays.toString(arr));
    }
}

class Max_Heap {
    private int[] array = new int[10];

    Max_Heap() {
        Arrays.fill(array, Integer.MIN_VALUE);
    }

    void insert(int num) {

    }

//    int delete() {
//
//    }

    void HeapSort() {

    }
}

class Heaps {
    public static void main(String[] args) {
        Min_Heap m = new Min_Heap();
        int[] arr = {5, 7, 8, 9, 10, 11, 14, 17, 13};
        for (int num : arr) {
            m.insert(num);
        }
        System.out.println(Arrays.toString(m.HeapSort()));
    }
}