package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ListGraph {
    // dfs 탐색을 위한 배열
    boolean[] visited;
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public ListGraph(int size) {
        this.graph = new ArrayList<>();
        this.visited = new boolean [size+1];
        for (int i=0; i<size+1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // 그래프 추가
    public void put(int x, int y) {
        // 무방향이면 하나만
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public void printGraph() {
        for (int i=1; i<graph.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");
            for (int j=0; j<graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void dfs(int indexNode) {
        // 방문처리
        this.visited[indexNode] = true;
        System.out.print(indexNode + " ");
        for (int i : this.graph.get(indexNode)) {
            if (!this.visited[i]) {
                dfs(i);
            }
        }
    }

    public void bfs(int indexNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(indexNode);
        visited[indexNode] = true;
        while (!queue.isEmpty()) {
            // 넣은 값을 출력
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i : this.graph.get(node)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void clearVisitArray() {
        for (int i=0; i<visited.length; i++) {
            this.visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int size = 8;
        ListGraph graph = new ListGraph(size);
        
//        graph.put(1, 2);
//        graph.put(1, 3);
//        graph.put(2, 3);
//        graph.put(2, 4);
//        graph.put(3, 4);
//        graph.put(3, 5);
//        graph.put(4, 5);
//        graph.put(4, 6);

        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(1, 8);
        graph.put(2, 1);
        graph.put(2, 7);
        graph.put(3, 1);
        graph.put(3, 4);
        graph.put(3, 5);
        graph.put(4, 3);
        graph.put(4, 5);
        graph.put(5, 3);
        graph.put(5, 4);
        graph.put(6, 7);
        graph.put(7, 2);
        graph.put(7, 6);
        graph.put(7, 8);
        graph.put(8, 1);
        graph.put(8, 7);
        graph.printGraph();

        System.out.println("1부터 DFS탐색 : ");
        graph.dfs(1);

        graph.clearVisitArray();

        System.out.println();
        System.out.println("1부터 BFS탐색 : ");
        graph.bfs(1);

    }

}
