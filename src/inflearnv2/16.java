package inflearnv2;
import java.util.Scanner;

class problem16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i : solution(N)) {
            System.out.print(i + " ");
        }
        sc.close();
    }    

    public static int[] solution(int N) {
        int[] answer = new int[N];
        // 피보나치 수열 첫 두개의 숫자는 1이다
        answer[0] = 1;
        answer[1] = 1;

        for (int i=2; i<N; i++) {
            // 자기 이전과 그 이전의 숫자의 합을 더해준 값을 새로 저장하면된다.
            answer[i] = answer[i-1] + answer[i-2];
        }

        return answer;
    }
}
