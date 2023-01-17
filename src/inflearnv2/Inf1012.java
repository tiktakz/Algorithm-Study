package inflearnv2;
import java.util.*;

class Inf1012 {
    // Tomato 클래스
    static class Tomato {
        int x, y;
        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //static int times;
    static int n,m;
    static int graph[][];
    static boolean visited[][];
    static Queue<Tomato> q = new LinkedList<>();
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};

    // 1 익은 토마토 / 0 익지 않은 토마토 / -1 토마토 없음
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        visited = new boolean[n][m];
        graph = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) q.offer(new Tomato(i,j));
            }
        }

        BFS();

        int answer = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    break;
                }
                else {
                    answer = Math.max(answer, graph[i][j]);
                }
            }
        }
        System.out.println(answer-1);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            for (int i=0; i<4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<m) {
                    // 익지 않은 토마토인 경우
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = 1; // 익힘 처리
                        visited[nx][ny] = true;
                        q.offer(new Tomato(nx, ny));
                        graph[nx][ny] = graph[t.x][t.y] +1;
                    }
                }
            }
        }
    }
}
