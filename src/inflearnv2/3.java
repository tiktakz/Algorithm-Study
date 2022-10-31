package inflearnv2;
import java.util.Scanner;

class problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // next()는 다음 토큰, nextLine() 은 '\n' 포함
        sc.close();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String[] newStr = str.split(" "); // 띄어쓰기를 기준으로 문자열을 나누어 배열에 담음
        int max = newStr[0].length(); // 최대길이를 구하기 위해서 우선 기준을 첫번째 문자열의 길이 저장
        String answer = ""; // 답을 담을 변수 answer
        
        for (String s : newStr) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        return answer;
    }
}