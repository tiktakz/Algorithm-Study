package algorithms;

import java.util.Arrays;

class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {7,5,9,0,3,6,2,4,8};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
