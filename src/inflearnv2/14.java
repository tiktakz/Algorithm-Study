package inflearnv2;
import java.util.Scanner;

class problem14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++) { arr[i] = sc.nextInt(); }
        System.out.println(solution(N,arr));
        sc.close();
    }

    public static int solution(int N, int[] arr) {
        int answer = 1; // 맨 앞에 있는 학생은 무조건 보임. 
        int max = arr[0];

        for (int i=1; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }
}