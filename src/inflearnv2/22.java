package inflearnv2;
import java.util.Scanner;

class problem22 {
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
        // 격자판에서 지정한 위치에서의 상하좌우를 구하는 방법
        // dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1} 초기화 해놓고 좌표를 새로 구하는 방법을 사용
        // i + dx[k] (k는 <4 까지 돈다), j + dy[k] 를 구해서 좌표값을 구한다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                boolean flag = true; // 봉우리인지 아닌지 확인. 봉우리가 맞으면 더 확인 안해도 됨
                for (int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) { // [nx][ny] 는 4개의 방향인데 그것이 하나라도 나보다 크면 봉우리가 아니기 때문에 flag = false;
                        // nx,ny는 0보다 작으면 범위에 해당하지 않음. 또한 배열보다 커도 범위를 초과하기 때문에 조건을 추가해주어야한다.
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++; //봉우리가 맞으면 -> false가 되지 않고 나왔다면 봉우리가 맞기 때문에 answer++ 해준다
            }
        }
        return answer;
    }
}
