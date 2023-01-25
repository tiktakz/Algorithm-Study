package thisiscodingtest;
import java.util.*;

class ct2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        long result = number.charAt(0) -'0';

        // 앞의 숫자가 0이거나 1이면 '+' 수행하고 그 이외에는 '*' 수행해야 제일 큰 수

        for (int i=1; i<number.length(); i++) {
            if (number.charAt(i)-'0' <= 1 || result <=1) {
                result += number.charAt(i) - '0';
            }
            else {
                result *= number.charAt(i) - '0';
            }
        }

        System.out.println(result);
    }
}
