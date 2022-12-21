package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

class BJ1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int find = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        int lp = 0;
        int rp = arr.length - 1;

        while (lp < rp) {
            int sum = arr[lp] + arr[rp];
            if (sum == find) {
                answer++;
                lp++;
                rp--;
            } else if (sum > find) {
                rp--;
            }
            else {
                lp++;
            }
        }

        System.out.println(answer);

    }
}
