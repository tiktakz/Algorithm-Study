package revision;
import java.util.*;

class rev2 {
    static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];
        // 1이 괴물있고 0이 괴물 없음
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String tmp = sc.nextLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }
        BFS(0,0);
        System.out.println(graph[n-1][m-1]);
    }

    public static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        while (!q.isEmpty()) {
            Node cv = q.poll();
            for (int i=0; i<4; i++) {
                int nx = cv.x + dx[i];
                int ny = cv.y + dy[i];
                if (nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (graph[nx][ny] == 0) continue;
                    if (graph[nx][ny] == 1) {
                        graph[nx][ny] = graph[cv.x][cv.y] + 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
