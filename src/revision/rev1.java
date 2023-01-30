package revision;
import java.util.*;

class rev1 {
    static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int count, n, m;
    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i=0; i<n; i++) {
            String tmp = sc.nextLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    //BFS(i,j);
                    DFS(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void BFS(int x, int y) {
        q.offer(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<n && ny<m) {
                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    DFS(nx,ny);
                }
            }
        }
    }
}
