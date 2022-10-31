package inflearnv2;
import java.util.Scanner;

class problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        sc.close();
    }

    public static String solution(String str) {
        char[] charArr = str.toCharArray();

        int lt = 0;
        int rt = str.length()-1;
        // isAlphabetic을 통해 특수문자가 아니면 건너간다.
        // 둘다 특수문자가 아닌 경우에는 4번 문제와 동일하게 교환을 해주면 된다.
        while (lt < rt) {
            if (!Character.isAlphabetic(charArr[lt])) {
                lt++;
            }
            else if (!Character.isAlphabetic(charArr[rt])) {
                rt--;
            }
            else {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                rt--;
                lt++;
            }
        }
        return String.valueOf(charArr);
        //String answer = String.valueOf(charArr);
        //return answer;
    }
}