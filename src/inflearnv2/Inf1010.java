package inflearnv2;
import java.util.*;

class Inf1010 {
    public static int[][] graph;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new int[8][8];
        for (int i=1; i<=7; i++) {
            for (int j=1; j<=7; j++) {
                graph[i][j] = sc.nextInt();
            }
        }


        graph[1][1] = 1;
        for (int i=1; i<=7; i++) {
            for (int j=1; j<=7; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        DFS(1,1);
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        if (x==7 && y==7) answer++;
        else {
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx>=1 && nx<=7 && ny>=1 && ny<=7 && graph[nx][ny] ==0) {
                    graph[nx][ny] = 1;
                    DFS(nx,ny);
                    graph[nx][ny] = 0;
                }
            }
        }
    }
}
