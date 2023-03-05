import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int n,m,r,count;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n+1];
        graph = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i=0; i<graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        
        distance = new int[n+1];
        count = 1;
        bfs(r);
        
        for (int i=1; i<=n; i++) {
            System.out.println(distance[i]);
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        distance[start] = count;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i=0; i<graph.get(node).size(); i++) {
                if (!visited[graph.get(node).get(i)]) {
                    q.offer(graph.get(node).get(i));
                    visited[graph.get(node).get(i)] = true;
                    distance[graph.get(node).get(i)] = ++count;
                }
            }
        }
    }
}
