package inflearnv2;
import java.util.Scanner;

class problem11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = ""; // 문자를 압축해서 새로운 문자열 반환해야하기 때문에 선언
        str += " "; // 연속된 문자열인지 확인하려면 다음 문자를 비교해야되는데 마지막 문자인 경우 비교할 대상이 무조건 없음. 하지만 다 돌려면 기존의 String보다 1 커야함
        int count = 1; // 1개인 경우에는 숫자를 쓰지 않음.ex) K두개면 K2 로 나와야하기 때문에 시작은 1

        // str.length() 까지 돌면 마지막 문자 Index Out of Bound 에러 뜸.
        // 그래서 str.length()의 하나 전까지만 돌고 마지막 문자는 아까 str+= " "을 통해서 정상적으로 돌아갈 수 있다.
        for (int i=0; i<str.length()-1; i++) {
            // 연속되면 count를 늘려줌
            if (str.charAt(i) == str.charAt(i+1)) {
                count++;
            }
            // 연속문자가 끊기면 정답에 해당 문자를 넣고 2개 이상인 경우에만 숫자를 출력이기에 
            // 조건을 추가해주고 다시 count=1 초기화해주면서 다시 다른 문자 연속되는지 확인
            else {
                answer += str.charAt(i);
                if (count >= 2) {
                    answer += count;
                    count = 1;
                }
            }
        }

        return answer;
    }
}
