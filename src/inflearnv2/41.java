package inflearnv2;
import java.util.*;

class problem41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String must = sc.next();
        String plan = sc.next();
        System.out.println(solution(must, plan));
        sc.close();
    }    

    public static String solution(String must, String plan) {
        Queue<Character> Q = new LinkedList<>();
        String answer = "YES";
        for (char c : must.toCharArray()) {
            Q.offer(c);
        }

        for (char c : plan.toCharArray()) {
            if (Q.contains(c)) {
                if (c != Q.poll()) {
                    return "NO";
                }
            }
        }

        if (!Q.isEmpty()) {
            return "NO";
        }
        return answer;
    }
}
