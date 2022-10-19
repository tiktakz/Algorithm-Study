package inflearn;
import java.util.Scanner;

class Main3_3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,k,arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int maxSum = 0;
        int answer = 0;
        for (int i=0; i<k; i++) {
            maxSum += arr[i];
        }
        answer = maxSum;
        
        for (int i=k; i<n; i++) {
            maxSum += (arr[i]-arr[i-k]);
            answer = Math.max(answer,maxSum);
        }

        return answer;
    }
}