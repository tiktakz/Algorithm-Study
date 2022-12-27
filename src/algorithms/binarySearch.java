package algorithms;
import java.util.*;
// 이진탐색 구현하기


class binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원소의 개수: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("찾는 값: ");
        int find = sc.nextInt();
        System.out.println("배열 원소 입력");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("< 재귀 이진 탐색 > ");
        System.out.println(recursiveBinarySearch(arr,find,0, n-1));
        System.out.println("< 반복 이진 탐색 > ");
        System.out.println(loopBinarySearch(arr, find));
    }

    // 재귀호출을 이용한 이진탐색
    public static int recursiveBinarySearch(int[] arr, int find, int start, int end) {
        if (start > end) return -1; // 이진탐색 못하는 조건
        int mid = (start + end) / 2;
        if (find == arr[mid]) return mid; // 값 바로 찾음

        // 찾는 값이 더 크면 오른쪽 탐색
        else if (find > arr[mid]) {
            return recursiveBinarySearch(arr, find, mid+1, end);
        }
        // 작으면 왼쪽 탐색
        else
            return recursiveBinarySearch(arr, find, start, mid - 1);
    }

    // 반복을 이용한 이진탐색
    public static int loopBinarySearch(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (find == arr[mid]) return mid;
            else if (find < arr[mid]) {
                end = mid -1;
            }
            else start = mid + 1;
        }
        return -1; // 찾지 못함
    }
}
