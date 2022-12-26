package thisiscodingtest;

import java.util.Scanner;

class CT0403 {
    public static int n,m,x,y,direction;
//    public static int[] dx = {0,1,0,-1};
//    public static int[] dy = {-1,0,1,0};

    // 문제에서 북:0, 동:1, 남:2, 서:3 으로 설정해놨기 때문에
    // 순서가 중요함.
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int[][] arr = new int[50][50];

    public static void turnLeft() {
        // dx[] dy[]에는 왼쪽으로 회전하면 마주할 수 있는 4방면의 좌표 구해놨음.
        // 처음 기준으로 왼쪽 방향을 보니, 현재 방향에서 -1하면 다음 왼쪽 방향 구해짐.
        // 총 4가지 방향(인덱스로는 3) 까지 있으니, 마지막 방향에 오면 다시 첫방향으로.
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] visited = new int[50][50]; // 방문한 좌표를 체크한다
        int count = 1; // 이동 횟수
        int turnTime = 0; // 회전 횟수. 4번 회전했다는것은 모두 이동 불가. 즉 종료
        visited[x][y] = 1; // 첫 입력 좌표는 방문을 했다

        while (true) {
            turnLeft();
            // 방향을 바꾸고 이동할 새로운 좌표의 값을 구해놓는다
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (arr[nx][ny] == 0 && visited[nx][ny] == 0) {
                count++;
                visited[nx][ny] = 1; // 방문 했으니 해당 좌표는 1로 저장함.
                x = nx;
                y = ny;
                turnTime = 0;
                continue;
            }
            else {
                turnTime++;
            }

            if (turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                else break;
                turnTime = 0;
            }
        }

        System.out.println(count);

    }
}
