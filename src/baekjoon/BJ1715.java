package baekjoon;
import java.util.*;

class BJ1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 가장 낮은 숫자들을 먼저 더해야하기 때문에 우선순위 큐를 사용해서
        // 낮은값들을 먼저 뽑아서 더하는 방식으로 간다
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            pq.offer(num); // 우선순위큐 이기 때문에 poll()할때 작은 값이 먼저 나옴
        }

        int answer = 0;

        // 큐에 숫자가 두개 있어야 더 할 수 있음
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer += a+b;
            pq.offer(answer); // 더한값을 다시 넣어줘야 최대 횟수 가능
            // 10+20 = 30 했다면, 30 + 40 해야되기 때문에 30넣어줌
        }
        System.out.println(answer);
    }
}
