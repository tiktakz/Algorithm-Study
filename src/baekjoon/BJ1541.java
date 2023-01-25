package baekjoon;
import java.util.*;

class BJ1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();

        // 제일 작은 수를 만들기 위해서는 제일 큰 수를 빼면 된다
        String[] str = temp.split("\\-"); // '-' 부호를 기준으로 나누기

        int result = 0; // 계산결과를 담음
        for (int i=0; i<str.length; i++) {
            // '+' 로 묶인 숫자들은 더 해주어야함
            String[] plusArr = str[i].split("\\+");
            int calc = 0;
            for (String number : plusArr) {
                calc += Integer.parseInt(number);
            }

            // 첫번째 숫자는 무조건 더해야함. (앞뒤는 숫자이기 때문에)
            if (i==0) result += calc;
            else result -= calc; // 나머지 숫자는 빼야 커짐
        }
        System.out.println(result);
    }
}
