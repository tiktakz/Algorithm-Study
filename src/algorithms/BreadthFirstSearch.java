package algorithms;
import java.util.*;

// BFS 알고리즘

class BreadthFirstSearch {
    public static boolean visited[] = new boolean[9]; // 1~8, 각 노드값과 인덱스 일치시키기 위해 9
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프 만들기

    // BFS 함수
    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true; // 첫 시작 노드는 방문처리

        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " "); // 첫 노드 뽑아서 출력
            // 방문하지 않은 노드 탐색하여 큐에 삽입한다
            for (int i=0; i<graph.get(x).size(); i++) {
                int y = graph.get(x).get(i); // 인접한 방문하지 않은 노드 가져옴

                // 방문하지 않았다면
                if (!visited[y]) {
                    q.offer(y); // 큐에 넣어주고
                    visited[y] = true; // 방문처리 해줌
                }
            }
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

        BFS(1);
    }
}
