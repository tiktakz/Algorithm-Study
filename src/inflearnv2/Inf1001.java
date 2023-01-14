package inflearnv2;
import java.util.*;

class Inf1001 {
    static int n, total;
    static int[] arr;
    static String answer = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        DFS(0,0);
        System.out.println(answer);
    }

    public static void DFS(int index, int sum) {
        if (index == n) {
            if (total - sum == sum) answer = "YES";
        }
        else {
            DFS(index+1, sum+arr[index]);
            DFS(index+1, sum);
        }
    }
}
