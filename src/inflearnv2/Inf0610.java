package inflearnv2;

import java.util.*;

class Inf0610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(arr, c));
    }

    public static int solution(int[] arr, int c) {
        Arrays.sort(arr); // 이분탐색을 위해서 정렬
        int answer = 0;
        int start = 1;
        int end = arr[arr.length-1];

        while (start <= end) {
            int mid = (start + end) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public static int count(int[] arr, int distance) {
        int count = 1;
        int point = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - point >= distance) {
                count++;
                point = arr[i];
            }
        }
        return count;
    }
}
