package thisiscodingtest;

import java.util.Arrays;
import java.util.Scanner;

class CT0703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] riceCake = new int[n];
        for (int i=0; i<n; i++) riceCake[i] = sc.nextInt();

        Arrays.sort(riceCake); // 이진탐색을 위해 정렬

        System.out.println(binarySearch(riceCake, m));

    }

    public static int binarySearch(int[] riceCake, int m) {
        int start = 0;
        int end = riceCake[riceCake.length-1];
        if (start > end) return 0;
        int answer=0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for (int cake : riceCake) {
                if (cake > mid) {
                    sum += cake-mid;
                }
            }

            if (sum > m) start = mid+1;
            else {
                answer = mid;
                end = mid-1;
            }
        }
        return answer;
    }
}
