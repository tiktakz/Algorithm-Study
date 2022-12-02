package inflearnv2;
import java.util.*;

class problem40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
        sc.close();
    }

    public static int solution(int n, int m) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            for (int i=1; i<m; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();
            if (Q.size() == 1) {
                answer = Q.poll();
            }
        }

        return answer;
    }
    
}
