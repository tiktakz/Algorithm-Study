package algorithms;

// 인접행렬 그래프 Adjacency Matrix Graph
class MatrixGraph {
    private int[][] graph;

    public MatrixGraph(int size) {
        // 입력되는 정점의 값 (x,y)는 모두 0보다 큰 수
        // 그렇기 때문에 그래프의 (x,y)는 1로 시작하기 위해서 size+1
        this.graph = new int[size+1][size+1];
    }

    // 무방향 : 방향이 없기 때문에 양쪽에 모두 추가해주어야함
    public void put(int x, int y) {
        // 가중치가 있는 그래프를 만들면
        // put 메소드의 매개변수로 가중치 변수를 만들고 graph[x][y] = graph[y][x] = 가중치; 로 설정
        graph[x][y] = graph[y][x] = 1;
    }

    public void printGraph() {
        System.out.print("   " + 1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + " " + 6);
        System.out.println();
        for (int i=1; i<graph.length; i++) {
            System.out.print(i + "|");
            for (int j=1; j<graph[i].length; j++) {
                System.out.print(" " + graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 6;
        MatrixGraph graph = new MatrixGraph(size);

        // 노드추가
        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 3);
        graph.put(2, 4);
        graph.put(3, 4);
        graph.put(3, 5);
        graph.put(4, 5);
        graph.put(4, 6);

        graph.printGraph();
    }
}
