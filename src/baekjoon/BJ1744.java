package baekjoon;
import java.util.*;

class BJ1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 수열에 양수, 음수, 1, 0 다 있음
        // 양수의 경우 큰 값 * 큰 값 해야 가장 큰 값
        // 음수는 서로 곱하면 양수가 되는 점에서 가장 작은값 * 가장 작은 값
        // 1은 곱하는 것보다 더하고, 0도 곱하는 것보다 더하는게 좋다
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder()); // 기본적으로 오름차순이기에 역순으로
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        int zeroes = 0;
        int ones = 0;

        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            if (num == 1) ones++;
            if (num == 0) zeroes++;
            if (num > 1) plusPQ.offer(num);
            else minusPQ.offer(num);
        }

        // 각 큐 계산
        int answer = 0;
        while (plusPQ.size() > 1) {
            int a = plusPQ.poll();
            int b = plusPQ.poll();
            answer += a*b;
        }

        // 큐에 숫자가 남아있으면 그냥 더한다
        if (!plusPQ.isEmpty()) answer += plusPQ.poll();

        while (minusPQ.size() > 1) {
            int a = minusPQ.poll();
            int b = minusPQ.poll();
            answer += a*b;
        }

        // 음수가 남아있는데 0이 없으면 그대로 더 해줘야함
        // 0이 있으면 곱해주면 0이여서 최대값으로 나옴
        if (!minusPQ.isEmpty() && zeroes == 0) {
            answer += minusPQ.poll();
        }

        // 마지막에는 1의 개수를 더 함. 1이 1개면 1, 2개면 2... 라서 그대로 더함
        answer += ones;

        System.out.println(answer);
    }
}
