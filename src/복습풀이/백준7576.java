import java.util.*;

public class Main {
    static class Tomato {
        int x, y;
        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int m,n,answer;
    static Queue<Tomato> q = new LinkedList<>();
    static int[][] graph;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        graph = new int[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    q.offer(new Tomato(i,j));
                }
            }
        }
        
        bfs();
        
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                else {
                    max = Math.max(max, graph[i][j]);
                }
            }
        }
        System.out.println(max-1);
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            for (int i=0; i<4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if (nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[t.x][t.y] + 1;
                        q.offer(new Tomato(nx,ny));
                    }
                }
            }
        }
    }
}
