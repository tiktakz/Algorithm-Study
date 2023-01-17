package inflearnv2;
import java.util.*;

class Inf1013 {
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static int[][] graph;
    static boolean[][] visited;
    static int n, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    DFS(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<n && ny>=0 && ny<n) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    DFS(nx, ny);
                }
            }
        }
    }
}
