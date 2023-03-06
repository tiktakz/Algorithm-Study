import java.util.*;

class Main {
    static class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
       }
    }
  
    static int n, m;
    static boolean[][] visited;
    static int[][] graph;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};

    public static int BFS(int x, int y) {
        Queue<Node1> q = new LinkedList<>();
        q.offer(new Node(x,y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx>=n || ny>=m || nx<0 || ny<0) continue;
                if (graph[nx][ny] == 0) continue;
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    graph[nx][ny] = graph[cx][cy] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
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
