package inflearnv2;
import java.util.Scanner;

class problem21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        // 행과 열의 합을 임시로 저장해놓을 변수 sum1, sum2
        int sum1, sum2;
        int answer = Integer.MIN_VALUE; // 최대값을 구할 것이기 때문에 제일 작은 정수값으로 초기화해놓는다
        for (int i=0; i<n; i++) {
            // 한줄, 한열 구하고 나서 다음 행열을 구할때는 초기화하고 다시 구해야함
            sum1 = 0;
            sum2 = 0;
            for (int j=0; j<n; j++) {
                // arr[j][i] 는 i가 고정이고 j가 움직이기 때문에 열을 구할 수 있음
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(sum1, answer);
            answer = Math.max(sum2, answer);
        }

        // 대각선의 합을 구해야한다
        sum1 = 0;
        sum2 = 0;

        for (int i=0; i<n; i++) {
            sum1 += arr[i][i]; // 대각선 (우하향)는 i,j값 동일함
            sum2 += arr[i][n-i-1]; // 대각선(좌하향)는 i값은 1씩 커지지만 j는 배열의 길이-i-1만큼 줄어드는 패턴을 갖고 있음
        }
        answer = Math.max(sum1, answer);
        answer = Math.max(sum2, answer);

        return answer;
    }
}
