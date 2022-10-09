import java.util.Scanner;

class Main3_6{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n,k,arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int count = 0;
        int lt = 0;
        int answer = 0;

        for (int rt=0; rt<n; rt++) {
            if (arr[rt] == 0) {
                count++;
            }
            while (count > k) {
                if (arr[lt] == 0) {
                    count--;
                }
                lt++;
            }
            answer = Math.max(answer,rt-lt+1);
        }        

        return answer;
    }
}