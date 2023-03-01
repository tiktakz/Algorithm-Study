import java.util.*;

public class Main {
    public static int n,m,k,x,count;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        
        graph = new ArrayList<>();
        visited = new int[n+1];
        
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            visited[i] = -1;
        }
        
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        
        bfs(x);
        
        boolean flag = false;
        for (int i=1; i<=n; i++) {
            if (visited[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) System.out.println(-1);
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int city = q.poll();
            for (int i=0; i<graph.get(city).size(); i++) {
                int nextCity = graph.get(city).get(i);
                if (visited[nextCity] == -1) {
                    visited[nextCity] = visited[city] + 1;
                    q.offer(nextCity);
                }
            }
        }
    }
}
