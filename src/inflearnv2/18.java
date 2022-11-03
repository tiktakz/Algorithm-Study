package inflearnv2;
import java.util.Scanner;
import java.util.ArrayList;

class problem18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : solution(n,arr)) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static int flipNumber(int number) {
        // 숫자를 뒤집는 알고리즘
        int flipNum = 0;
        while(number != 0) {
            flipNum = flipNum*10 + number%10;
            number /= 10;
        }
        return flipNum;
    }

    public static boolean isPrime(int number) {
        // 소수 판별 알고리즘
        // 1은 소수 아니니 false
        // 이후 2부터 나누어서 나누어 떨어지는 숫자가 있다면 소수가 아니기 때문에 return false
        // 그 이외에는 return true
        if (number == 1) {
            return false;
        }

        for (int i=2; i<number; i++) {
            if (number%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> solution(int n, int[] arr) {
        // 만든 함수를 사용해서 뒤집은 숫자가 소수이면 ArrayList에 뒤집은 숫자를 저장하도록
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (isPrime(flipNumber(arr[i]))) {
                answer.add(flipNumber(arr[i]));
            }
        }
        return answer;
    }
}
