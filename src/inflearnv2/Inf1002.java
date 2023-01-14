package inflearnv2;
import java.util.*;

class Inf1002 {
    static int n, answer, weight;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        weight = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0,0);
        System.out.println(answer);
    }

    public static void DFS(int index, int sum) {
        if (sum > weight) return;
        if (index == n) answer = Math.max(answer, sum);

        else {
            DFS(index+1, sum+arr[index]);
            DFS(index+1, sum);
        }
    }
}
