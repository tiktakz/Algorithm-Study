package baekjoon;
import java.util.*;

class BJ13023 {
    static boolean flag;
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=0; i<n; i++) {
            visited = new boolean[n];
            DFS(i,1);
        }
        System.out.println(0);
    }

    public static void DFS(int start, int depth) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
        }
        visited[start] = true;

        for (int i=0; i<graph.get(start).size(); i++) {
            int cv = graph.get(start).get(i);
            if (!visited[cv]) {
                visited[cv] = true;
                DFS(cv, depth + 1);
                visited[cv] = false;
            }
        }
    }
}
