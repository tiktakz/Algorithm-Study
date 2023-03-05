import java.util.*;

class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int computers, networks, answer; // computer(노드), networks(간선)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        computers = sc.nextInt();
        networks = sc.nextInt();

        visited = new boolean[computers+1];

        for (int i=0; i<=computers; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<networks; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1); // 1번 컴퓨터부터 시작한다
        System.out.println(answer);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i=0; i<graph.get(node).size(); i++) {
                int current_node = graph.get(node).get(i);
                if (!visited[current_node]) {
                    visited[current_node] = true;
                    answer++;
                    q.offer(current_node);
                }
            }
        }
    }
}
