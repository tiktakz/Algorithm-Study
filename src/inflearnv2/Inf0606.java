package inflearnv2;

import java.util.Arrays;
import java.util.Scanner;

class Inf0606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int[] arrcopy = arr.clone();
        Arrays.sort(arrcopy);

        for (int i=0; i<n; i++) {
            if (arr[i] != arrcopy[i]) {
                System.out.print(i+1 + " ");
            }
        }
    }
}
