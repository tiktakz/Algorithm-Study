package baekjoon;
import java.util.*;

class Main2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        sc.close();
        int result = A*B*C;
        String str = Integer.toString(result);

        int[] numbers = new int[10];
        for (int i=0; i<str.length(); i++) {
            numbers[str.charAt(i) - '0']++;
        }

        for (int i : numbers) {
            System.out.println(i);
        }
    }    
}
