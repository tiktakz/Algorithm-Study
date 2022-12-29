package thisiscodingtest;
import java.util.*;

class ct2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();

        long result = number.charAt(0)-'0';

        for (int i=1; i<number.length(); i++) {
            // 현재 숫자를 가져옴
            int num = number.charAt(i) - '0';
            // 0이거나, 1이면 곱하기보다 더하기, 그 외에는 곱해야 숫자가 커짐
            // 첫 result에는 첫번째 숫자가 담기는데, 여기서 0또는1이 나오면 더하기가 유리함
            // 그래서 조건 2개 설정
            if (num <= 1 || result <= 1) {
                result += num;
            }
            else result *= num;
        }

        System.out.println(result);
    }
}
