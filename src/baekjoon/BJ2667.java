package baekjoon;
import java.util.*;

class BJ2667 {
    public static int n, nx, ny, count;;
    public static int[][] graph = new int[26][26]; // 그래프 생성
    public static boolean[][] visited = new boolean[26][26]; // 방문여부
    public static int[] dx = {1,-1,0,0}; // 4방향 상 하 좌 우
    public static int[] dy = {0,0,-1,1};
    public static ArrayList<Integer> counter = new ArrayList<>(); // 단지 개수 카운팅

    public static boolean DFS(int x, int y) {
        if (x<0 || x>n || y<0 || y>n) return false; // 범위 안에 없으면 false
        visited[x][y] = true;

        // 4방향에 대해서
        for (int i=0; i<4; i++) {
            nx = x+dx[i];
            ny = y+dy[i];
            // 새로운 좌표가 단지 좌표 안에 있는게 맞고
            if (nx<n && nx>=0 && ny<n && ny>=0) {
                // 해당 좌표가 1(즉 단지가 있음) 이고 방문한적 없으면 DFS수행
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    DFS(nx, ny);
                    count++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<n; i++) {
            String arr = sc.nextLine();
            for (int j=0; j<n; j++) {
                graph[i][j] = arr.charAt(j) - '0';
            }
        }

        // 모든 좌표마다 DFS를 수행
        // 단지가 있고, 방문한적 없을때만 수행.
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    DFS(i, j);
                    counter.add(count);
                }
            }
        }
        Collections.sort(counter);
        System.out.println(counter.size());
        for (int i : counter) {
            System.out.println(i);
        }
    }
}
