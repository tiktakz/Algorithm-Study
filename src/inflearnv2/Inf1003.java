package inflearnv2;
import java.util.*;

class Inf1003 {
    static int n,m;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        DFS(0,0,0,arr1, arr2);
        System.out.println(answer);

    }

    public static void DFS(int index, int sum, int min, int[] points, int[] time) {
        if (min > m) return;
        if (index == n){
            answer = Math.max(answer, sum);
        }
        else {
            DFS(index+1, sum+points[index], min+time[index], points, time);
            DFS(index+1, sum,min, points, time);
        }
    }
}
