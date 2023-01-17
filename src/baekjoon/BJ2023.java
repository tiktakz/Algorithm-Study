package baekjoon;
import java.util.*;

class BJ2023 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    public static void DFS(int num, int index) {
        if (index == n && isPrime(num )) {
            System.out.println(num);
        }

        for (int i=1; i<10; i++) {
            if (i%2 == 0) continue; // 짝수는 소수가 안됨
            if (isPrime(num*10 + i)) DFS(num*10+i, index+1);
        }
    }

    public static boolean isPrime(int number) {
        for (int i=2; i<=number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
