package baekjoon;
import java.util.*;
// 배열
class Main10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        sc.close();

        int answer = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == v) {
                answer++;
            }
        }

        System.out.println(answer);
    }    
}
