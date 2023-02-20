package baekjoon;
import java.util.*;

class BJ1916 {
    static class Station implements Comparable<Station> {
        int stop, cost;
        public Station(int stop, int cost) {
            this.stop = stop;
            this.cost = cost;
        }
        @Override
        public int compareTo(Station other) {
            return this.cost - other.cost;
        }
    }

    static int[] distance;
    static ArrayList<ArrayList<Station>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        distance = new int[n+1];
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Station(b,c));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);

        System.out.println(distance[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Station> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Station(start, 0));

        while (!pq.isEmpty()) {
            Station st = pq.poll();
            int currentStation = st.stop;
            int currentCost = st.cost;

            if (currentCost > distance[currentStation]) continue;

            for (Station s : graph.get(currentStation)) {
                int cost = s.cost + currentCost;
                if (distance[s.stop] > cost) {
                    distance[s.stop] = cost;
                    pq.offer(new Station(s.stop, cost));
                }
            }
        }
    }
}
