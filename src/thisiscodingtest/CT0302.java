package thisiscodingtest;

import java.util.Arrays;
import java.util.Scanner;

class CT0302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int firstMax = arr[arr.length-1];
        int secondMax = arr[arr.length-2];
        int sum = 0;

        while (true) {
            for (int i=0; i<k; i++) {
                if (m == 0) {
                    break;
                }
                sum += firstMax;
                m--;
            }
            if (m==0) {
                break;
            }
            sum += secondMax;
            m--;
        }

        System.out.println(sum);

    }
}
