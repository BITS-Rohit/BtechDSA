package JAVA.MTE;

import java.util.Arrays;
import java.util.Scanner;

public class QuickAscDesc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {13, 8, 5, 6, 18, 0};
        System.out.print("Enter Choice : ");
        String choice = sc.next();
        quick(array, 0, array.length - 1, choice);
        System.out.println(Arrays.toString(array));
    }

    static void quick(int[] array, int low, int high, String choice) {
        if (low < high) {
            int pivot = array[(low + high) / 2];
            if (choice.equalsIgnoreCase("Asc")) {
                int start = low;
                int end = high;
                while (start <= end) {
                    while (array[start] < pivot) {
                        start++;
                    }
                    while (array[end] > pivot) {
                        end--;
                    }
                    if (start <= end) {
                        int temp = array[start];
                        array[start] = array[end];
                        array[end] = temp;
                        start++;
                        end--;
                    }
                }
                quick(array, low, end, choice);
                quick(array, start, high, choice);
            }
            if (choice.equalsIgnoreCase("Desc")) {
                int start = low;
                int end = high;
                while (start <= end) {
                    while (array[start] > pivot) {
                        start++;
                    }
                    while (array[end] < pivot) {
                        end--;
                    }
                    if (start <= end) {
                        int temp = array[start];
                        array[start] = array[end];
                        array[end] = temp;
                        start++;
                        end--;
                    }
                }
                quick(array, low, end, choice);
                quick(array, start, high, choice);
            }
        }
    }
}
