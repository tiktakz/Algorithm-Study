import java.util.*;

public class Main {
    static class Virus implements Comparable<Virus> {
        int x, y, index, time;
        public Virus(int x, int y, int index, int time) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.time = time;
        }
        
        @Override
        public int compareTo(Virus other) {
            return this.index - other.index;
        }
    }
    
    static int n, k, s, x, y;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Virus> al = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        graph = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] != 0) {
                    al.add(new Virus(i,j,graph[i][j], 0));
                }
            }
        }
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        
        Collections.sort(al);
        
        bfs();
        
        if (graph[x-1][y-1] == 0) {
            System.out.println(0);
        } else {
            System.out.println(graph[x-1][y-1]);
        }
    }
    
    public static void bfs() {
        Queue<Virus> q = new LinkedList<>();
        for (Virus v : al) {
            q.offer(v);
        }
        while (!q.isEmpty()) {
            Virus currentVirus = q.poll();
            if (currentVirus.time == s) {
                return;
            }
            for (int i=0; i<4; i++) {
                int nextVirus_x = currentVirus.x + dx[i];
                int nextVirus_y = currentVirus.y + dy[i];
                if (nextVirus_x<n && nextVirus_y<n && nextVirus_x>=0 && nextVirus_y>=0) {
                    if (graph[nextVirus_x][nextVirus_y] == 0) {
                        graph[nextVirus_x][nextVirus_y] = currentVirus.index;
                        q.offer(new Virus(nextVirus_x, nextVirus_y, currentVirus.index, currentVirus.time+1));
                    }
                }
            }
        }
    }
}
