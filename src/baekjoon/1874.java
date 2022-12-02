package baekjoon;
import java.util.*;

class Main1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            int value = arr[i];
            if (value >= num) {
                while (value >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int p = stack.pop();
                if (p > value) {
                    System.out.println("NO");
                    System.exit(0);
                }
                else {
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb.toString());
    }    
}
