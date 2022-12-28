package thisiscodingtest;
import java.util.*;

class CT0804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1000];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for (int i=3; i<=n; i++) {
            dp[3] = (dp[i-1] + (dp[i-2] * 2)) % 796796;
        }

        System.out.println(dp[n]);
    }
}
