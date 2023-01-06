package baekjoon;
import java.util.*;

class BJ2606 {
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

        DFS(1); // 1번 컴퓨터부터 시작한다
        System.out.println(answer);
    }

    public static void DFS(int start) {
        visited[start] = true;
        for (int i=0; i<graph.get(start).size(); i++) {
            int cv = graph.get(start).get(i);
            if (!visited[cv]) {
                visited[cv] = true;
                answer++; // 감염PC 추가
                DFS(cv); // 다른 연결 PC확인
            }
        }
    }
}
