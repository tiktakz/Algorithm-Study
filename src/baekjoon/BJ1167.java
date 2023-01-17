package baekjoon;
import java.util.*;

class Edge {
    int v, dist;

    public Edge(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}


class BJ1167 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<n; i++) {
            int s = sc.nextInt();
            while (true) {
                int e = sc.nextInt();
                if (e == -1) break;
                int v = sc.nextInt();
                graph.get(s).add(new Edge(e,v));
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1); // 임의의 노드에서 가장 멀리 있는 노드 탐색
        int max = 1;
        for (int i=2; i<=n; i++) {
            if (distance[max] < distance[i]) {
                max = i; // 최대값 노드 탐색
            }
        }

        // 이후 가장 긴 노드에서 가장 멀리 떨어져있는 노드 탐색. 그것이 트리의 지름이 됨
        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(max);

        Arrays.sort(distance); // 오름차순 정렬이기 때문에 마지막 값이 최대 거리
        System.out.println(distance[n]);

    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cv = q.poll();
            for (Edge e : graph.get(cv)) {
                int edge = e.v;
                int cost = e.dist;
                if (!visited[edge]) {
                    visited[edge] = true;
                    q.offer(edge);
                    distance[edge] = distance[cv] + cost;
                }
            }
        }
    }

}
