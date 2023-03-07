import java.util.*;
import java.io.*;

public class Main {
    static int[] graph;
    static boolean[] visited;
    static int n,m;
    static int distance[];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[101];
        visited = new boolean[101];
        distance = new int[101];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = b;
        }
        
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = b;
        }        
        
        bfs();
    }
    
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distance[1] = 0;
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int pos = q.poll();
            if (pos == 100) {
                System.out.println(distance[pos]);
                break;
            }
            for (int i=1; i<=6; i++) {
                int npos = pos + i;
                if (npos > 100) continue;
                if (visited[npos]) continue;
                visited[npos] = true;
                if (graph[npos] != 0) {
                    if (!visited[graph[npos]]) {
                        visited[graph[npos]] = true;
                        distance[graph[npos]] = distance[pos] + 1;
                        q.offer(graph[npos]);
                    }
                }
                else {
                    q.offer(npos);
                    distance[npos] = distance[pos] + 1;
                }
            }
        }
    }
}
