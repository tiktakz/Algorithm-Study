package thisiscodingtest;
import java.util.*;
import java.time.Duration;
import java.time.Instant;

class ct05 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 볼링공 개수
        int m = sc.nextInt(); // 최대 무개
        int[] balls = new int[n];
        for (int i=0; i<n; i++) balls[i] = sc.nextInt();

        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (balls[i] != balls[j]) answer++;
            }
        }
        Instant finish = Instant.now();
        System.out.println(answer);
        long time = Duration.between(start,finish).toSeconds();
        System.out.println("시간 " + time);

    }
}
