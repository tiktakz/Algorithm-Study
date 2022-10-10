import java.util.Scanner;

class Main3_4_1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(N,M,arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int count = 0;
        int pt = 0;
        int sum = 0;

        for (int rt=0; rt<n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                count++;
            }
            while (sum >= m) {
                sum -= arr[pt];
                pt++;
                if (sum == m) {
                    count++;
                }
            }
        }

        return count;
    }
}