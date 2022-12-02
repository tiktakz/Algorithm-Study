package baekjoon;
import java.util.*;

class Main2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> Q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            Q.offer(i);
        }
        sc.close();

        while (Q.size() > 1) {
            Q.poll();
            Q.offer(Q.poll());
        }

        System.out.println(Q.poll());
    }
}
