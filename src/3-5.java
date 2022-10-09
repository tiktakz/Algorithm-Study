    import java.util.Scanner;

    class Main3_5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            System.out.println(solution(N));
        }

        public static int solution(int N) {
            int answer = 0;
            int sum = 0;
            int lt=0;
            int arrSize = N/2 + 1;

            int[] arr = new int[arrSize];
            for (int i=0; i<arrSize; i++) {
                arr[i] = i+1;
            }

            for (int rt=0; rt<arrSize; rt++) {
                sum += arr[rt];
                System.out.println("for" + rt + " sum " + sum);
                if (sum == N) {
                    answer++;
                }
                while (sum >= N) {
                    System.out.println("while " + sum);
                    sum -= arr[lt++];
                    if (sum == N) {
                        answer++;
                        break;
                    }
                }
            }
            return answer;
        }
    }