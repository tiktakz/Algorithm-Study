package inflearnv2;
import java.util.Scanner;

class problem27 {
    // sliding window alogirthm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,k,arr));

        sc.close();
    }    

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int max = 0;

        // k만큼의 윈도우가 생성되니 우선 k만큼의 윈도우의 값을 저장한다
        for (int i=0; i<k; i++) {
            max += arr[i];
        }
        
        answer = max;

        // 첫 k만큼의 합을 저장했기 때문에 i=k부터 시작한다.
        // 다음 k만큼의 합은 기존의 k만큼의 합에서 하나 큰 인덱스 값의 숫자를 더하고 윈도우의 제일 첫 숫자를 빼주면 된다
        // 그 인덱스는 i번째와 i-k 번째 인덱스가 된다.
        for (int i=k; i<n; i++) {
            max += (arr[i] - arr[i-k]);
            answer = Math.max(max, answer);
        }

        return answer;
    }
}
