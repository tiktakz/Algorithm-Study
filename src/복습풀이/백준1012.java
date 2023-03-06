import java.util.*;

public class Main {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    
    static int t,m,n,k;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[][] graph;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i=0; i<t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            
            visited = new boolean[m][n];
            graph = new int[m][n];
        
            for (int j=0; j<k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
            }
        
            int answer = 0;
            
            for (int k=0; k<m; k++) {
                for (int j=0; j<n; j++) {
                    if (graph[k][j] == 1 && visited[k][j] == false) {
                        answer++;
                        bfs(k,j);
                    }
                }
            }
            System.out.println(answer);
        }
    } // main
    
    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx>=0 && ny>=0 && nx<m && ny<n) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
