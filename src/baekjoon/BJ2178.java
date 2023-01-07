package baekjoon;
import java.util.*;

class Node1 {
    private int x, y;
    public Node1 (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class BJ2178 {
    static int n, m;
    static boolean[][] visited;
    static int[][] graph;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};

    public static int BFS(int x, int y) {
        Queue<Node1> q = new LinkedList<>();
        //visited[x][y] = true;
        q.offer(new Node1(x,y));

        while (!q.isEmpty()) {
            Node1 node = q.poll();
//            x = node.getX();
//            y = node.getY();
            int cx = node.getX();
            int cy = node.getY();
            //System.out.println("xy" + x + " " + y);
            //System.out.println("cxcy" + cx + " " + cy);
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx>=n || ny>=m || nx<0 || ny<0) continue;
                if (graph[nx][ny] == 0) continue;
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    graph[nx][ny] = graph[cx][cy] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Node1(nx, ny));
                }
            }
        }
        return graph[n-1][m-1];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        visited = new boolean[n][m];
        graph = new int[n][m];

        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(BFS(0,0));
    }
}
