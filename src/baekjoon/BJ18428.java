package baekjoon;
import java.util.*;
import java.io.*;

class BJ18428 {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] graph; // 초기 정보
    static char[][] copy; // 복사본
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        graph = new char[6][6];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }

        DFS(0);
        System.out.println("NO");
    }

    public static void DFS(int object) {
        // Object(장애물)이 3개이면서 BFS의 실행값이 true이면 감시를 피할 수 있다는 것이다
        if (object == 3) {
            if (BFS()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        // 장애물을 배치한다
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] == 'X') {
                    graph[i][j] = 'O';
                    DFS(object + 1);
                    graph[i][j] = 'X';
                }
            }
        }
    }

    public static boolean BFS() {
        Queue<Node> q = new LinkedList<>();
        copy = new char[6][6]; // 원본 배열을 건들지 않기 위해서 새로운 복사본을 만듬
        // 장애물 설치한 그래프 복사
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                copy[i][j] = graph[i][j];
                // 선생님이 있는 좌표는 큐에 저장하고 확인한다
                if (copy[i][j] == 'T') {
                    q.offer(new Node(i,j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node cv = q.poll();
            // 뽑은 선생님의 위치 기준으로 상하좌우 좌표를 구한다
            for (int i = 0; i < 4; i++) {
                int nx = cv.x;
                int ny = cv.y;
                while (true) {
                    // 현재 위치 기준으로 인접 한칸만 구하는 것이 아니기 때문에
                    // 계속 상하좌우로 뻗어나간다
                    nx += dx[i];
                    ny += dy[i];
                    // 뻗아나간 좌표의 위치가 맵을 벗어난다면 break
                    if (nx<0 || ny<0 || ny>=n || nx>=n) break;
                    // 장애물을 만나면 그 이상으로는 학생을 발견할 수 없기 때문에 break
                    if (copy[nx][ny] == 'O') break;
                    // 학생을 만난다면 학생이 감시를 피할 수 없는 경우가 생긴거니 바로 false를 return
                    if (copy[nx][ny] == 'S') return false;
                }
            }
        }
        // 위에서 false가 안나왔다는 것은 감시를 피할 수 있다는 것이다.
        return true;
    }
}
