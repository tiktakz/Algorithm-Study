package baekjoon;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Stack<Integer> stack = new Stack<>();
        

        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                stack.push(num);
            }
            if (num == 0) {
                stack.pop();
            }
        }
        
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        System.out.println(stack.size());
        System.out.println(answer);
    }
}