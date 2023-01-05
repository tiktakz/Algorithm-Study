package inflearnv2;
import java.util.*;

class Inf0912_1 {
    // 행렬로 풀이
    public static int n, m, answer=0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void DFS(int x) {
        visited[x] = true;
        if (x == n) answer++;
        else {
            for (int i=0; i<graph.get(x).size(); i++) {
                if (!visited[graph.get(x).get(i)]) {
                    visited[graph.get(x).get(i)] = true;
                    DFS(graph.get(x).get(i));
                    visited[graph.get(x).get(i)] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        DFS(1);
        System.out.println(answer);
    }
}
