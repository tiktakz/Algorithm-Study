package inflearnv2;
import java.util.Scanner;

class problem28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,m,arr));

        sc.close();
    }    
    
    public static int solution(int n, int m, int[] arr) {
        // 동적으로 움직이는 슬라이딩 윈도우를 만들어야함
        // 두개의 포인터 lp, rp는 각각 0번째 인덱스부터 시작
        int answer = 0;
        int lp = 0;
        int sum =0;

        // for문을 통해 rp 포인터만 증가시키면서 합을 확인하여
        // 합이 6이면 정답을 하나 카운팅하면 된다.
        // 합이 6보다 작으면 for문을 통해서 알아서 증가
        // 그러다가 합이 6이 되거나, 6보다 커지면 lp 포인터를 만져야한다.
        // 우선 lp번째에 있는 값을 빼주고 lp 포인터를 증가시킨다.
        // 그리고 다시 합이 6인지 확인한다. 그렇지 않다면 계속 lp++ 해주는것이다. 
        for (int rp=0; rp<n; rp++) {
            sum += arr[rp];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= arr[lp];
                lp++;
                if (sum == m) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
