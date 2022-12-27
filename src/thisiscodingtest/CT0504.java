package thisiscodingtest;
import java.util.*;

class Node {
    private int x;
    private int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}


class CT0504 {

    public static int n, m;
    public static int[][] graph = new int[201][201]; // 200개 이지만 첫 배열은 0이라서 사용 안함

    // 방향 상 하 좌 우
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static int bfs(int x, int y) {
        // BFS 알고리즘
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));

        // Queue가 empty할때까지 반복
        while (!queue.isEmpty()) {
            // queue에 들어가있는 노드를 가져오고
            // x,y에 값 할당
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i=0; i<4; i++) {
                // 상하좌우 확인할것임
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나는 경우
                if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
                // 0 인 경우 괴물이 있기 때문에 무시한다
                if (graph[nx][ny] == 0) continue;
                // 1이면 갈 수 있는 곳이기 때문에 이전 노드의 값에 1을 더 해줌 (거리를 구하는 것이기 때문에)
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    // 해당 값에서 또 BFS 수행
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return graph[n-1][m-1]; // 출구는 [n][m] 에 있음
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }
}
