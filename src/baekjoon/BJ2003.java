package baekjoon;
import java.util.Scanner;

class BJ2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int pt1 = 0;
        int pt2 = 0;
        int sum = 0;
        int answer = 0;

        while (true) {
            if (sum == m) {
                answer++;
                sum -= arr[pt1++];
            }
            else if (sum > m) {
                sum -= arr[pt1++];
            }
            else if (pt2 ==n) break;
            else {
                sum += arr[pt2++];
            }
        }

        System.out.println(answer);
    }
}
