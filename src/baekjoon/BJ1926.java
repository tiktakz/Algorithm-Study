package baekjoon;
import java.util.*;

class BJ1926 {
    static int n, m, count, counter;
    static int[][] graph;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    counter = 1;
                    count++;
                    DFS(i,j);
                }
            }
        }
        System.out.println(count);
        if (count == 0) {
            System.out.println(0);
        }
        else System.out.println(max);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        max = Math.max(max, counter);

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<n && ny>=0 && ny<m) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    counter++;
                    DFS(nx, ny);
                }
            }
        }

    }
}
