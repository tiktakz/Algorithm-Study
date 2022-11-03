package inflearnv2;
import java.util.Scanner;

class problem19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(N,arr));
    }

    public static int solution(int N, int[] arr) {
        int point = 0; // 연속점수
        int answer = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                // 1이면 point++를 통해서 point를 누적한다
                point++;
                answer += point;
            }
            if (arr[i] == 0) {
                point = 0;
            }
        }
        return answer;
    }
}
