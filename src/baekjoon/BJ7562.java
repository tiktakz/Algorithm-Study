package baekjoon;
import java.io.*;
import java.util.*;

class Position {
    private int x, y;
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

class BJ7562 {
    static int N,sX,sY,eX,eY;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, -2, -2, -1, 1, 2,  2,  1};
    static int[] dy = {-2, -1,  1,  2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            // 체스판의 크기
            N = Integer.parseInt(br.readLine());

            // 체스판 초기화
            map = new int[N][N];
            // 방문배열 초기화
            visited = new boolean[N][N];

            // 시작좌표 입력
            st = new StringTokenizer(br.readLine());
            sX = Integer.parseInt(st.nextToken());
            sY = Integer.parseInt(st.nextToken());

            // 도착좌표 입력
            st = new StringTokenizer(br.readLine());
            eX = Integer.parseInt(st.nextToken());
            eY = Integer.parseInt(st.nextToken());

            // 출력
            BFS(sX, sY);
            for (int i =0; i<map.length; i++) {
                for (int j=0; j<map.length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(map[eX][eY]);
        }
    }

    public static void BFS(int start, int end) {
        Queue<Position> q = new LinkedList<>();
        visited[start][end] = true;
        q.offer(new Position(start, end));

        while (!q.isEmpty()) {
            Position tmp = q.poll();
            int tx = tmp.getX();
            int ty = tmp.getY();

            for (int i=0; i<8; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx>=0 && nx<N && ny>=0 && ny<N) {
                    if (!visited[nx][ny]) {
                        q.offer(new Position(nx, ny));
                        visited[nx][ny] = true;
                        map[nx][ny] = map[tx][ty] + 1;
                    }
                }
            }

        }
    }
}