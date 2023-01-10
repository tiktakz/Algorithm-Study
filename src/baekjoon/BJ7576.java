package baekjoon;
import java.util.*;

class Tomato {
    private int x, y;
    public Tomato(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}



class BJ7576 {
    static boolean visited[][];
    static int[][] map;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static int n,m,answer;
    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 1) q.offer(new Tomato(i,j));
            }
        }
        int max = Integer.MIN_VALUE;
        BFS();

//        for (int i=0; i<m; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                else max = Math.max(map[i][j], max);
            }
        }
        System.out.println(max-1);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Tomato tmp = q.poll();
            int tx = tmp.getX();
            int ty = tmp.getY();

            for (int i=0; i<4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx>=0 && nx<m && ny>=0 && ny<n) {
                    if (map[nx][ny] == 0) {
                        answer++;
                        map[nx][ny] = map[tx][ty] + 1;
                        q.offer(new Tomato(nx, ny));
                    }
                }
            }
        }
    }

}
