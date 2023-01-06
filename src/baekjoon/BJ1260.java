package baekjoon;
import java.util.*;

class BJ1260 {
    public static int n, m, v; // node, edge, start
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        visited = new boolean[n+1];
        graph = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=0; i<=n; i++) {
            Collections.sort(graph.get(i));
        }
        DFS(v);
        // bfs 위해서 초기화
        Arrays.fill(visited, false);
        System.out.println();
        BFS(v);
    }

    public static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int cv : graph.get(start)) {
            if (!visited[cv]) {
                visited[cv] = true;

                DFS(cv);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int cv : graph.get(x)) {
                if (!visited[cv]) {
                    visited[cv] = true;
                    q.offer(cv);
                }
            }
        }
    }
}
