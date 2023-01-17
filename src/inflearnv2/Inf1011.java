package inflearnv2;
import java.util.*;

class Inf1011 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] distance;
    public static int[][] graph;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new int[8][8];
        distance = new int[8][8];
        for (int i=1; i<=7; i++) {
            for (int j=1; j<=7; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        BFS(1,1);
        for (int i=1; i<=7; i++) {
            for (int j=1; j<=7; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
        if (distance[7][7] == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(distance[7][7]);
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        graph[x][y] = 1;
        q.offer(new Point(x, y));


        while (!q.isEmpty()) {
            Point p = q.poll();
            //int tx = p.x
            //int ty = p.y;
            for (int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

//                if (nx<1 || ny<1 || nx>7 || ny>7) continue;
//                if (graph[nx][ny] == 1) continue;
                if (nx>=1 && ny>=1 && nx<=7 && ny<=7 && graph[nx][ny]==0) {
                    graph[nx][ny] = 1;
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}
