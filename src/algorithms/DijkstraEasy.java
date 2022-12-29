package algorithms;
import java.util.*;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}


class DijkstraEasy {
    public static final int INF = 987654321;
    // 100,000 개 가정
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int n, m, start; // 노드 수, 간선 수
    public static boolean[] visited = new boolean[1000001];
    // 최단 거리 저장 배열; 인덱스는 1부터 사용할것임
    public static int[] distance = new int[1000001];

    // 방문하지 않은 노드 중 가장 작은 값(최단거리) 구하기
    public static int getSmallestNode() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i=1; i<=n; i++) {
            if (distance[i] < min && !visited[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    // start 시작 노드부터 구함
    public static void dijkstra1(int start) {
        distance[start] = 0; // 자기 자신에서 자신으로 가는 거리는 0임
        visited[start] = true; // 방문처리
        for (int j=0; j<graph.get(start).size(); j++) {
            // 시작 노드에 대해서 연결된 간선 초기화
            distance[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        for (int i=0; i<n-1; i++) {
            // 가장 작은 노드의 인덱스 가져옴
            int now = getSmallestNode();
            visited[now] = true;
            for (int j=0; j<graph.get(now).size(); j++) {
                int cost = distance[now] + graph.get(now).get(j).getDistance();
                if (cost < distance[graph.get(now).get(j).getIndex()]) {
                    distance[graph.get(now).get(j).getIndex()] = cost;
                }
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
        dijkstra1(start);

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
