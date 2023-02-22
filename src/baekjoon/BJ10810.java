package baekjoon;
import java.util.*;

class BJ10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<m; i++) {
            int l = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            for (int p=l-1; p<j; p++) {
                arr[p] = k;
            }
        }

        for (int i : arr) System.out.print(i + " ");
    }
}
