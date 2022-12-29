package thisiscodingtest;
import java.util.*;

class myNode implements Comparable<myNode> {
    private int city;
    private int time;

    public myNode(int city, int time) {
        this.city = city;
        this.time = time;
    }

    public int getCity() {return this.city;}
    public int getTime() {return this.time;}

    @Override
    public int compareTo(myNode other) {
        if (this.time < other.time) {return -1;}
        else return 1;
    }
}

class CT0903 {
    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<myNode>> graph = new ArrayList<>();
    public static int[] distance = new int[30001];
    public static int n,m,start;

    public static void dijkstra(int start) {
        PriorityQueue<myNode> pq = new PriorityQueue<>();
        pq.offer(new myNode(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            myNode node = pq.poll();
            int dist = node.getTime();
            int currentNode = node.getCity();

            if (distance[currentNode] < dist) {continue;}

            for (int i=0; i<graph.get(currentNode).size(); i++) {
                int cost = graph.get(currentNode).get(i).getTime();
                if (cost < distance[graph.get(currentNode).get(i).getCity()]) {
                    distance[graph.get(currentNode).get(i).getCity()] = cost;
                    pq.offer(new myNode(graph.get(currentNode).get(i).getCity(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<myNode>());
        }

        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new myNode(y,z));
        }

        Arrays.fill(distance, INF);

        int count = 0;
        int max_distance = 0;

        dijkstra(start);

        for (int i=1; i<=n; i++) {
            if (distance[i] != INF) {
                count++;
                max_distance = Math.max(max_distance, distance[i]);
            }
        }

        System.out.println(count-1 + " " + max_distance);
    }

}
