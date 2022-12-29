package algorithms;
import java.util.*;

class Node1 implements Comparable<Node1> {
    private int index;
    private int distance;

    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getDistance() {return this.distance;}
    public int getIndex() {return this.index;}
    @Override
    // PrioirtyQueue에서 우선순위를 기준으로 빼올건데, index와 distance 중에서 distance 기준으로
    public int compareTo(Node1 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

// PriorityQueue 사용한 개선된 다익스트라 알고리즘
public class DijkstraHard {
    public static final int INF = (int)1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int distance[] = new int[100001];

    public static void dijkstra(int start) {
        // 개선된 다익스트라는 우선순위큐를 사용. 방문 배열 필요없음
        PriorityQueue<Node1> pq = new PriorityQueue<>();
        // 자기 자신으로 가는 경로는 0
        pq.offer(new Node1(start,0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            // Comparable 구현했기 때문에 가장 거리가 짧은 노드를 가져온다
            Node1 node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지 비용(거리)
            int now = node.getIndex(); // 현재 노드의 인덱스
            if (distance[now] < dist) { continue; }
            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getDistance();
                if (cost < distance[graph.get(now).get(i).getIndex()]) { distance[graph.get(now).get(i).getIndex()] = cost; }
                pq.offer(new Node1(graph.get(now).get(i).getIndex(), cost));
                }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(distance, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (distance[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(distance[i]);
            }
        }
    }
}
