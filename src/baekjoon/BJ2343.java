package baekjoon;
import java.util.*;

class BJ2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = Arrays.stream(arr).max().getAsInt(); // 첫 포인터는 배열의 최대값
        int end = Arrays.stream(arr).sum(); // 끝 포인터는 블루레이 총 길이 (배열의 합)

        int answer = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            if (count(arr, mid) <= m) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int count(int[] arr, int capacity) {
        int count = 1; // DVD 개수
        int sum = 0; // DVD 길이

        for (int i : arr) {
            if (sum+i > capacity) { // 용량 초과
                count++;
                sum = i;
            }
            else sum += i;
        }

        return count;
    }
}
