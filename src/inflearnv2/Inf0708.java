package inflearnv2;
import java.util.*;

class Inf0708 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();
        int cow = sc.nextInt();
        System.out.println(BFS(position, cow));
    }

    public static int BFS(int position, int cow) {
        boolean[] visited = new boolean[10001]; // 총 10,000개의 좌표
        int[] jumps = {1,-1,5}; // 앞1, 뒤1, 앞5 이동 가능
        Queue<Integer> q = new LinkedList<>();

        visited[position] = true;
        q.offer(position);
        int level = 0;

        while (!q.isEmpty()) {
            int length = q.size(); // 레벨별로 큐의 사이즈. 처음은 1개니까 1개, 그 다음은 3갈래 즉 3개
            for (int i=0; i<length; i++) {
                int x = q.poll();
                if (x == cow) return level; // 바로 뽑은 값이 목표지점이면 level 반환
                for (int j=0; j<jumps.length; j++) {
                    int nx = x + jumps[j]; // 이동할 수 있는 좌표 계산
                    if (nx >= 1 && nx <= 10000 && !visited[nx]) { // 이동할 수 있는 좌표가 방문하지 않았고 갈 수 있어야함
                        visited[nx] = true;
                        q.offer(nx);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
