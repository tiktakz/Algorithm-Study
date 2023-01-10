package baekjoon;
import java.util.*;
import java.io.*;

class BJ16928 {
    static int n,m;
    static int[] map;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[101];
        visited = new boolean[101];
        count = new int[101];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }

        BFS();
        System.out.println(Arrays.toString(count));
        System.out.println(count[100]);
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        // 1번칸에서 100번칸으로 이동하는 경우 확인
        count[1] = 0;
        visited[1] = true;
        q.offer(1);

        while (!q.isEmpty()) {
            int position = q.poll();
            if (position == 100) {
                System.out.println(count[position]);
                break;
            }


            // 주사위 굴리기
            for (int i=1; i<=6; i++) {
                int nextPosition = position + i;
                if (nextPosition > 100) continue;
                if (visited[nextPosition]) continue;
                visited[nextPosition] = true;
                if (map[nextPosition] != 0) {
                    if (!visited[map[nextPosition]]) {
                        visited[map[nextPosition]] = true;
                        q.offer(map[nextPosition]);
                        count[map[nextPosition]] = count[position] + 1;
                    }
                }

                else {
                    q.offer(nextPosition);
                    count[nextPosition] = count[position] + 1;
                }


            }
        }
    }



}
