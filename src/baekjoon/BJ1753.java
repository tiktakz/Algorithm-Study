package baekjoon;
import java.util.*;

class BJ1753 {
    static class Edge implements Comparable<Edge> {
        int node, value;
        public Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
        @Override
        public int compareTo(Edge other) {
            return this.value - other.value;
        }
    }

    static int[] distance;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int start = sc.nextInt();

        distance = new int[n+1];
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);

        for (int i=0; i<k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        dijkstra(start);

        for (int i=1; i<=n; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentEdge = edge.node;
            int currentDistance = edge.value;
            if (currentDistance > distance[currentEdge]) continue;

            for (Edge e : graph.get(currentEdge)) {
                int newDistance = currentDistance + e.value;
                if (distance[e.node] > newDistance) {
                    distance[e.node] = newDistance;
                    pq.offer(new Edge(e.node, newDistance));
                }
            }
        }
    }
}
