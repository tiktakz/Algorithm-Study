package algorithms;
import java.util.*;

class DepthFirstSearch {
    public static boolean visited[] = new boolean[9]; // 1~8 까지의 노드데이터, 1번 인덱스부터 사용
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void DFS(int x) {
        visited[x] = true; // 현재 노드 방문처리
        System.out.print(x + " ");

        // x, 즉 현재 연결된 노드들 확인
        for (int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) DFS(y); // 방문하지 않았다면 해당 노드에서 DFS 수행
        }
    }
    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        DFS(2);
        System.out.println("---------");
    }
}
