package baekjoon;

import java.util.Scanner;

class BJ1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;

        int pt1 = 0, pt2 = 0;
        int sum = 0
        while (true) {
            if (sum >= s) {
                sum -= arr[pt1++];
                min = Math.min(min, (pt2-pt1) + 1);
            }
            else if (pt2 == n) {
                break;
            }else if (sum < s) {
                sum += arr[pt2];
                pt2++;
            }

        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }

        sc.close();
    }
}
