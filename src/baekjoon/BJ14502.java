package baekjoon;
import java.util.*;
import java.io.*;

class BJ14502 {
    static class Virus {
        int x, y;
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int answer = Integer.MIN_VALUE;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(s1[j]);
            }
        }
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                graph[i][j] = sc.nextInt();
//            }
//        }

        DFS(0);
        System.out.println(answer);

    }

    public static void DFS(int walls) {
        // 벽 3개를 다 세웠다면 바이러스 전파하고 넓이 구해봐야함
        if (walls == 3) {
            BFS();
            return;
        }

        // 벽 3개를 다 세우지 않았다면 3개를 세워봐야함
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    DFS(walls+1);
                    graph[i][j] = 0; // 다른 경우도 생각해봐야하니 다시 0으로 되돌려
                }
            }
        }
    }

    public static void BFS() {
        Queue<Virus> q = new LinkedList<>();
        int[][] virusmap = new int[8][8];
        // 벽 세운 맵 복사하기
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                virusmap[i][j] = graph[i][j];
//            }
//        }

        for (int i=0; i<n; i++) {
            virusmap[i] = graph[i].clone();
        }

        // 바이러스가 있는 곳부터 BFS
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (virusmap[i][j] == 2) {
                    q.offer(new Virus(i,j));
                }
            }
        }

        while (!q.isEmpty()) {
            Virus cv = q.poll();
            for (int i=0; i<4; i++) {
                int nx = cv.x + dx[i];
                int ny = cv.y + dy[i];
                if (nx>=0 && ny>=0 && nx<n && ny<m) {
                    if (virusmap[nx][ny] == 0) {
                        virusmap[nx][ny] = 2;
                        q.offer(new Virus(nx,ny));
                    }
                }
            }
        }
        countArea(virusmap);
    }

    public static void countArea(int[][] virusmap) {
        int counter = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (virusmap[i][j] == 0) {
                    counter++;
                }
            }
        }
        answer = Math.max(answer, counter);
    }
}
