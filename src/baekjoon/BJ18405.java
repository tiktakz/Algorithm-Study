package baekjoon;
import java.util.*;

class Virus implements Comparable<Virus> {
    private int x,y;
    private int time;
    private int index;

    public Virus(int x, int y, int index, int time) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.time = time;
    }

    public int getIndex() {
        return this.index;
    }

    public int getTime() {
        return this.time;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Virus other) {
        return this.index - other.index;
    }
}



class BJ18405 {
    static int[][] graph;
    static int n,k,s,x,y;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Virus> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        graph = new int[n+1][n+1];
        ArrayList<Virus> virus = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] != 0) virus.add(new Virus(i,j,graph[i][j], 0));
            }
        }

        s = sc.nextInt();;
        x = sc.nextInt();
        y = sc.nextInt();

        Collections.sort(virus);
        for (Virus v : virus) {
            q.offer(v);
        }

        BFS();
        System.out.println(graph[x-1][y-1]);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Virus cv = q.poll();
            int virusTime = cv.getTime();
            int virusIndex = cv.getIndex();
            int cx = cv.getX();
            int cy = cv.getY();

            if (virusTime == s) return;

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<n) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virusIndex;
                        q.offer(new Virus(nx, ny, virusIndex, virusTime+1));
                    }
                }
            }
        }
    }

}
