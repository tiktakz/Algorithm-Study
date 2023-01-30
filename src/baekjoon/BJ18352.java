package baekjoon;
import java.util.*;

class BJ18352 {
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n,k,x,m;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 도시 개수
        m = sc.nextInt(); // 도로 개수
        k = sc.nextInt(); // 거리 정보
        x = sc.nextInt(); // 시작 도시

        // 그래프 초기화
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문배열 초기화
        visited = new int[n+1];
        for (int i=0; i<=n; i++) {
            visited[i] = -1;
        }

        // 도시 정보 입력받기
        // 단방향
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BFS(x);

        boolean flag = false;
        // 방문배열의 인덱스에는 도시별 거리가 저장되기 때문에
        // k만큼의 거리인 인덱스를 찾으면 됨
        for (int i=1; i<=n; i++) {
            if (visited[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) System.out.println("-1");

    }

    public static void BFS(int start) {
        // 시작도시에서 시작도시까지의 거리는 0이다. (1 -> 1로 가는 거리는 0)
        visited[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start); // 시작 도시를 큐에넣으며 시작

        while (!q.isEmpty()) {
            int cv = q.poll();
            // 현재 도시와 인접한 도시들에 대해서
            // 방문한적이 없는경우 (즉 -1)이면 방문하고, 현재 도시에서 +1 해준 값으로
            // 거리를 업데이트한다.
            for (int i : graph.get(cv)) {
                if (visited[i] == -1) {
                    visited[i] = visited[cv] + 1;
                    q.offer(i);
                }
            }
        }

    }
}