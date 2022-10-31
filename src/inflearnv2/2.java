package inflearnv2;
import java.util.Scanner;

class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("풀이 1: " + solution1(str)); // StringBuilder 풀이
        System.out.println("풀이 2: " + solution2(str)); // String += 풀이
        sc.close();
    }

    public static String solution1(String str) {
        // 입력받은 문자열의 각 문자를 대소문자 구분하여
        // 소문자일 경우 대문자로, 대문자인 경우 소문자로 변환
        // 한문자씩 검사하기 위해서 str을 charArray로 바꿔줌

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString(); // StringBuilder 사용했기 때문에 생성된 sb를 toString함
    }

    public static String solution2(String str) {
        String answer = "";

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answer += Character.toLowerCase(c);
            }
            else {
                answer += Character.toUpperCase(c);
            }
        }

        return answer;
    }
}