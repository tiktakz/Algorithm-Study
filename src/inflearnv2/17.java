package inflearnv2;
import java.util.Scanner;

class problem17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(solution(N));
    } 
    
    public static int solution(int N) {
        // 에라토스테네스의 체
        // 배열을 모두 0으로 초기화해주고 배열을 돌기 시작한다
        // 소수를 만날경우, 카운터를 증가해주고 해당 숫자를 1로 바꾼다
        // 이후 해당 숫자의 배수들 또한 배열에서 모두 1로 바꾸어준다. 왜냐하면 해당 숫자의 배수라는건 해당 숫자를 약수로 갖고 자기 자신도 약수이기에
        // 소수가 될 수 없다.

        int answer = 0;
        int[] check = new int[N+1];
        // N+1의 크기로 배열을 생성하는 이유는 N으로 들어오는 번호까지의 인덱스를 검사해야하기 때문이다
        // N이 10으로 들어온다면 check[]은 0~9가 들어있는데 10까지 체크해야한다. 그렇기 때문에 +1을 해준다

        for (int i=2; i<=N; i++) {
            // 0과 1은 소수가 아니기 때문에 2부터 돌아준다
            if (check[i] == 0) {
                answer++;
                for (int j=i; j<=N; j=j+i) { // j=j+i는 해당 숫자의 배수만 체크. ex i=2, j= 2, 4, 6, ...
                    check[j] = 1;
                } 
            }
        }
        return answer;
    }
}
