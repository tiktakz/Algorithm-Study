package inflearnv2;
import java.util.Scanner;

class problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6]; // [n+1][6], 학생번호가 1번부터 있기 때문에 편의상 n+1, 학년은 1~5학년이 고정이기 때문에 6으로 설정
        for (int i=1; i<=n; i++) { // 0번째는 사용 안하기 때문에 1부터 돌린다
            for (int j=1; j<=5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        int max = Integer.MIN_VALUE;
        int studentNum = 0;
        // for문의 i,j는 학생 번호를 뜻한다. i는 1(번)일때 j번학생은 1~5번까지 돈다
        // 학생의 조합이 나오면 해당 학년을 비교하는게 k이다. i가 고정, j도 고정일때 k는 1~5학년을 다 비교한다
        // ex) i=1, j=2 일때 k는 1~5 다 돌아버린다. -> 1번학생, 2번학생이 1학년때 같은 반? 2학년? 3학년? ... 5학년? 을 비교하게 된다
        // 만약 같은 반이 나왔다면 break문으로 빠져나오는 것은 학생의 수를 세야하기 때문이다. 4번의 경우 3번학생과 2학년 3학년 둘다 같은 반이였는데
        // 둘다 count하게 된다면 4번 학생은 3번을 두번 counting하는 것이다.
        // 그래서 해당 학생과의 같은 반이 있었다면 한번만 카운트해준다
        // i for문을 한번 돌때마다 1번학생과 같은 반이였던 학생수가 count에 저장되기 때문에 최대값과 비교하고 '학생번호' 를 출력해야하기 때문에 정답에는 max가 아닌 해당 번호인 i를
        // 저장해주어야한다.
        for (int i=1; i<n+1; i++) {
            int count = 0;
            for (int j=1; j<n+1; j++) {
                for (int k=1; k<6; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                studentNum = i;
            }
        }
        return studentNum;
    }
}