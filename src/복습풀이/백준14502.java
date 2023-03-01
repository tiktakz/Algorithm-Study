import java.util.*;

public class Main {
    static class Virus {
        int x, y;
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int n,m;
    static int answer = Integer.MIN_VALUE;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        graph = new int[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        
        dfs(0);
        System.out.println(answer);
    }
    
    public static void countSafeZones(int[][] copyMap) {
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
    
    public static void dfs(int walls) {
        if (walls == 3) {
            bfs();
            return;
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(walls+1);
                    graph[i][j] = 0;
                }
            }
        }
    }
    
    public static void bfs() {
        Queue<Virus> q = new LinkedList<>();
        int[][] copyMap = new int[8][8];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                copyMap[i][j] = graph[i][j];
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (copyMap[i][j] == 2) {
                    q.offer(new Virus(i,j));
                }
            }
        }
        
        while (!q.isEmpty()) {
            Virus currentVirus = q.poll();
            for (int k=0; k<4; k++) {
                int xVirus = currentVirus.x + dx[k];
                int yVirus = currentVirus.y + dy[k];
                if (xVirus>=0 && yVirus>=0 && xVirus<n && yVirus<m) {
                    if (copyMap[xVirus][yVirus] == 0) {
                        copyMap[xVirus][yVirus] = 2;
                        q.offer(new Virus(xVirus, yVirus));
                    }
                }
            }
        }
        countSafeZones(copyMap);
    }
}
