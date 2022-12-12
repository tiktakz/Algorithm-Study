package baekjoon;
import java.util.*;
// 배열
class Main10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
