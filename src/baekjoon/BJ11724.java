package baekjoon;
import java.util.*;

class BJ11724 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int n, m, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 무방향 그래프이기 때문에 양쪽 다 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int i) {
        // 방문을 했다면 연결됨
        if (visited[i]) return;
        visited[i] = true;
        for (int cv : graph.get(i)) {
            if (!visited[cv]) {
                DFS(cv);
            }
        }
    }
}
