package inflearnv2;
import java.util.Scanner;

class problem20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i: solution(N,arr)) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static int[] solution(int N, int[] arr) {
        int[] answer = new int[N];
        // 자기 자신이 우선 제일 큰 숫자라고 가정하여 1등으로 설정해놓는다
        // 이후 배열을 탐색하며 숫자를 비교하는데, 자기보다 크면 등수는 낮아질 것이다
        // 그렇기 때문에 자기보다 큰 숫자를 만나면 +1을 해주게 된다

        // 그렇지 않다면 자기 자신이 1등인 셈이다.
        // 그래서 이중for문을 통해서 정답을 구했다.


        for (int i=0; i<N; i++) {
            answer[i] = 1;
            for (int j=0; j<N; j++) {
                if (arr[i] < arr[j]) {
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}
