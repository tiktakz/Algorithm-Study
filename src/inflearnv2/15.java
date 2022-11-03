package inflearnv2;
import java.util.Scanner;

class problem15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] arr1 = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i=0; i<N; i++) {
            arr1[i] = sc.nextInt();
        }

        sc.close();
        for (char c : solution(N,arr,arr1)) {
            System.out.println(c);
        }
    }

    public static char[] solution(int N, int[] arr, int[] arr1) {
        // 가위:1 바위:2 보:3
        // A가 이기는 경우는 숫자의 합이 -2, 1 
        // B가 이기는 경우는 숫자의 합이 2, -1
        // 비기는 경우는 합이 0
        char[] answer = new char[N];
        for (int i=0; i<N; i++) {
            if (arr[i] - arr1[i] == -2 || arr[i] - arr1[i] == 1) {
                answer[i] = 'A';
            }
            else if (arr[i] - arr1[i] == 2 || arr[i] - arr1[i] == -1) {
                answer[i] = 'B';
            }
            else {
                answer[i] = 'D';
            }
        }
        return answer;
    }
}
