import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int n;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static ArrayList<Node> al = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        
        map = new char[n][n];
        
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        
        dfs(0);
        System.out.println("NO");
        
    }
    
    public static void dfs(int obstacle) {
        if (obstacle == 3) {
            if (bfs()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(obstacle+1);
                    map[i][j] = 'X';
                }
            }
        }
    }
    
    public static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        char[][] copy = new char[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                copy[i][j] = map[i][j];
                if (copy[i][j] == 'T') {
                    q.offer(new Node(i, j));
                }
            }
        }
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i=0; i<4; i++) {
                int nx = node.x;
                int ny = node.y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx<0 || ny<0 || nx>=n || ny>=n) break;
                    if (nx>=0 && ny>=0 && nx<n && ny<n) {
                        if (copy[nx][ny] == 'O') break;
                        if (copy[nx][ny] == 'S') return false;
                    }
                }
            }
        }
        return true;
    }
}
