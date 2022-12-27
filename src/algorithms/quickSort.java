package algorithms;

import java.util.Arrays;

// 퀵정렬
// 피벗 선택은 제일 왼쪽으로 설정
class quickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void QuickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) { // 엇갈릴때까지 반복
            // pivot보다 큰 데이터 찾을 때 까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // pivot보다 작은 데이터 찾을 때 까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;

            // 엇갈리면 피벗값과 작은 데이터를 교환하고 그렇지 않으면 작은 데이터와 큰 데이터를 교환
            if (left > right) swap(arr,right, start);
            else swap(arr, left, right);
        }

        QuickSort(arr, start, right-1);
        QuickSort(arr, right+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {5,7,9,0,3,1,6,2,4,8};
        QuickSort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
