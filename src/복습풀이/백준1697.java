import java.util.*;

public class Main {
    static int n,k;
    static int[] distance;
    static int[] moves = {-1,1,2};
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[100001];
        distance = new int[100001];
        n = sc.nextInt();
        k = sc.nextInt();
        
        if (n == k) {
            System.out.println("0");
        }
        else bfs(n);
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 1;
        
        while (!q.isEmpty()) {
            int pos = q.poll();
            for (int i=0; i<3; i++) {
                int npos;
                if (i == 2) {
                    npos = pos * 2;
                }
                else {
                    npos = pos + moves[i];
                }
            
                if (npos == k) {
                    System.out.println(distance[pos]);
                    return;
                }
            
                if (npos>=0 && npos<=100000 && distance[npos] == 0) {
                    distance[npos] = distance[pos] + 1;
                    q.offer(npos);
                }
            }
        }
    }
}
