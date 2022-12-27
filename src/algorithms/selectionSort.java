package algorithms;
import java.util.*;

class selectionSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void SelectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int minIndex = i; // 가장 작은 원소의 인덱스
            for (int j=i+1; j<arr.length; j++) {
                // 배열을 탐색하며 더 작은 값이 있는지 확인하고 있으면 바꿔줌
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,5,9,0,3,6,2,4,8};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
