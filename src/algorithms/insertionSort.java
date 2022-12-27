package algorithms;
import java.util.*;

class insertionSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void InsertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr,j,j-1);
                }
                else break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,5,9,0,3,6,2,4,8};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
