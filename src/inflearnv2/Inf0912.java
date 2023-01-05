package inflearnv2;
import java.util.*;

class Inf0912 {
    // 행렬로 풀이
    public static int n, m, answer=0;
    public static int[][] graph;
    public static boolean[] visited;

    public static void DFS(int x) {
        if (x==n) answer++;
        // 1번 정점에서 N번 정점까지
        visited[x] = true;
        for (int i=1; i<=n; i++) {
            if (graph[x][i]==1 && visited[i] == false) {
                visited[i] = true;
                DFS(i);
                visited[i] = false; // 체크해제 해주어야 다시 1부터 시작해서 다른 경로 있는지 확인할 수 있음
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        graph = new int[n+1][n+1];
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        DFS(1);
        System.out.println(answer);
    }
}
