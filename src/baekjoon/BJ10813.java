package baekjoon;
import java.util.*;

class BJ10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            swap(a,b,arr);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void swap(int x, int y, int[] arr) {
        int temp = 0;
        temp = arr[x-1];
        arr[x-1] = arr[y-1];
        arr[y-1] = temp;
    }
}
