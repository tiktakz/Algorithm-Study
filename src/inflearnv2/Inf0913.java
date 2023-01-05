package inflearnv2;
import java.util.*;

class Inf0913 {
    public static int n, m, answer;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int distance[];

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        distance[start] = 0; // 시작지점은 거리가 0
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            // cv: currentvalue, 현재 연결된 노드 찾기
            for (int cv : graph.get(x)) {
                if (!visited[cv]) {
                    visited[cv] = true;
                    q.offer(cv);
                    distance[cv] = distance[x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        visited = new boolean[n+1];
        distance = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BFS(1);

        for (int i=2; i<=n; i++) {
            System.out.println(i + ": " + distance[i]);
        }
    }
}
