package algorithms;
import java.util.*;

public class FloyedWarshall {
    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph = new int[501][501]; // 최대 간선수가 500개 존재한다고 가정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 무한으로 모두 초기화
        for (int i=0; i<501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 가는 비용은 0으로 초기화
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (i == j) {graph[i][j] = 0;}
            }
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 플로이드 워셜 알고리즘
        for (int k=1; k<=n; k++) {
            for (int a=1; a<=n; a++) {
                for (int b=1; b<=n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }


    }
}
