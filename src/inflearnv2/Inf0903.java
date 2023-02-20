package inflearnv2;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    int money, time;
    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture other) {
        return other.time - this.time;
    }
}

class Inf0903 {
    static int n, max = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int m = sc.nextInt();
            int t = sc.nextInt();
            al.add(new Lecture(m,t));
            if (t>max) max = t;
        }
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(al);
        int j = 0;
        for (int i=max; i>=1; i--) {
            for (; j<n; j++) {
                if (al.get(j).time < i) break;
                pq.offer(al.get(j).money);
            }
            if (!pq.isEmpty()) answer += pq.poll();
        }
        System.out.println(answer);
    }
}
