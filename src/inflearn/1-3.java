
package inflearn;
import java.util.Scanner;
import java.util.Arrays;

//review
class Main1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String[] strArr = str.split(" ");
        String answer = strArr[0];
        int max = strArr[0].length();
        for (String s : strArr) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        return answer;
    }
}