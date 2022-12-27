package thisiscodingtest;

import java.util.Arrays;
import java.util.Scanner;

class CT0702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] parts = new int[m];
        for (int i=0; i<m; i++) {
            parts[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 정렬
        Arrays.sort(arr);
        Arrays.sort(parts);

        for (int part : parts) {
            System.out.print(binarySearch(arr, part, 0, n-1) + " ");
        }
    }

    public static String binarySearch(int[] arr, int part, int start, int end) {
        if (start > end) return "no"; // 찾지 못함
        int mid = (start + end) / 2;
        if (part == arr[mid]) return "yes";
        else if (part > arr[mid]) return binarySearch(arr, part, mid+1, end);
        else return binarySearch(arr, part, start, mid-1);
    }
}
