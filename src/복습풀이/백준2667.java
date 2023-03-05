import java.util.*;

public class Main {
    static int n, answer;
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> area = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        visited = new boolean[n+1][n+1];
        graph = new int[n+1][n+1];
        
        for (int i=0; i<n; i++) {
            String str = sc.nextLine();
            for (int j=0; j<n; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    answer = 1;
                    dfs(i,j);
                    area.add(answer);
                }
            }
        }
        
        Collections.sort(area);
        
        System.out.println(area.size());
        for (int i : area) {
            System.out.println(i);
        }
    }
    
    public static void dfs(int x, int y) {
        if (x<0 || y<0 || x>n || y>n) return;
        visited[x][y] = true;
        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<n && ny<n) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                answer++;
                dfs(nx, ny);
                }    
            }
        }
    }
}
