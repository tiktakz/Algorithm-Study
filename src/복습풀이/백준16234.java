package baekjoon;
import java.util.*;

public class BJ16234 {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, l, r, count;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        graph = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    ArrayList<Node> al = new ArrayList<>(); // 연합국가
                    int sum = 0;
                    if (!visited[i][j]) {
                        q.offer(new Node(i,j));
                        sum += graph[i][j];
                        al.add(new Node(i,j));
                        visited[i][j] = true;
                    }
                    else continue;

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        for (int k=0; k<4; k++) {
                            int nx = node.x + dx[k];
                            int ny = node.y + dy[k];

                            if (nx<0 || ny<0 || nx>=n || ny>=n) continue;
                            if (visited[nx][ny]) continue;

                            int diff = Math.abs(graph[node.x][node.y] - graph[nx][ny]);

                            if (diff<l || diff>r) continue;

                            q.offer(new Node(nx,ny));
                            al.add(new Node(nx, ny));
                            sum += graph[nx][ny];
                            visited[nx][ny] = true;

                        }
                    }

                    if (al.size() >= 2) {
                        int population = sum / al.size();
                        for (Node n : al) {
                            graph[n.x][n.y] = population;
                        }
                        moved = true;
                    }
                }
            }

            if (moved) {
                count++;
            }
            else {
                System.out.println(count);
                return;
            }
        }
    }
}
