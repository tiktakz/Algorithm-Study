package algorithms;
import java.util.*;

class Dijkstra {
    static class Node implements Comparable<Node> {
        int edge, distance;
        public Node(int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt();
        int cost = sc.nextInt();
        graph = new ArrayList<ArrayList<Node>>();

        for (int i=0; i<=edge; i++) {
            graph.add(new ArrayList<Node>());
        }

        distance = new int[edge+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i=0; i<cost; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b,c));
        }

        dijkstra(1);

        for (int i=1; i<=edge; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Cannot Go");
            }
            else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current_edge = node.edge;
            int current_distance = node.distance;
            if (current_distance > distance[current_edge]) continue;
            for (Node n : graph.get(current_edge)) {
                if (distance[n.edge] > current_distance + n.distance) {
                    distance[n.edge] = current_distance + n.distance;
                    pq.offer(new Node(n.edge, current_distance + n.distance));
                }
            }
        }
    }
}
