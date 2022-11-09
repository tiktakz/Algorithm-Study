package inflearnv2;
import java.util.*;

class problem29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
        sc.close();
    }

    public static int solution(int n) {
        int size = n/2 + 1; // '연속된' 자연수의 합이기 때문에 n까지의 숫자가 모두 필요없다
        // ex) n=15 이면 1,2,3,4,5,6,7,8 만 있으면 된다. 
        int[] arr = new int[size];
        for (int i=0; i<size; i++) {
            arr[i] = i+1;
        }

        int answer = 0;
        int lt = 0;
        int sum = 0;

        for (int rt=0; rt<size; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt];
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
