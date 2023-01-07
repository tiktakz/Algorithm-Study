package baekjoon;
import java.util.*;

class BJ1697 {
    static int n, k, nx, count;
    static boolean[] visited;
    static int[] moves = {1, -1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        visited = new boolean[100001];
        System.out.println(BFS(start, end));

    }

    public static int BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int cv = q.poll();
                if (cv == end) return count;
                for (int j=0; j<3; j++) {
                    if (j==2) nx = cv * 2;
                    else nx = cv + moves[j];

                    if (nx>=0 && nx<=100000 && !visited[nx]) {
                        visited[nx] = true;
                        q.offer(nx);
                    }
                }
            }
            count++;
        }
        return count;
    }
}
