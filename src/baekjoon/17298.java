package baekjoon;
import java.util.*;

class Main17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int[] answer = new int [n]; // 정답을 담을 배열
        Stack<Integer> stack = new Stack<>();

        stack.push(0); // 처음에 스택이 비어있으니, 0을 넣음 (0번째 인덱스 참조할 수 있음)

        for (int i=1; i<n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
			sb.append(answer[i]).append(' ');
		}
		System.out.println(sb);
    }    
}
