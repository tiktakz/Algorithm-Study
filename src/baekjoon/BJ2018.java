package baekjoon;
import java.util.Scanner;

class BJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int pt1 = 1;
        int pt2 = 1;

        int answer = 1;
        int sum = 1;

        while (pt2 != N) {
            if (sum == N) {
                answer++;
                pt2++;
                sum += pt2;
            }
            else if (sum < N) {
                pt2++;
                sum += pt2;
            }
            else {
                sum -= pt1;
                pt1++;
            }
        }
        System.out.println(answer);
    }
}
