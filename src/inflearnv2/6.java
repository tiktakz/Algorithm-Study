package inflearnv2;
import java.util.*;
import java.util.ArrayList;

class problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        solution(str);
        solution2(str);
    }

    public static void solution(String str) {
        // ArrayList 를 사용해서 str에 문자(c)가 없다면 추가해주었다
        // 만약 해당 문자가 이미 존재한다면 넣지 않고
        // 마지막에 ArrayList al 을 String으로 바꿔 출력해주었다.
        ArrayList<Character> al = new ArrayList<>();
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (!al.contains(c)) {
                al.add(c);
            }
        }
        String answer = "";
        for (char i : al) {
            answer += i;
        } 
        System.out.println(answer);
    }

    public static void solution2(String str) {
        // indexOf() 메소드를 사용한 풀이
        // indexOf()는 해당 문자가 발견된 최초의 위치를 반환해준다
        // 그렇기 때문에 for문을 돌면서 최초의 위치와 i가 같으면 추가해준다
        String answer = "";
        for (int i=0; i<str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        System.out.println(answer);
    }
}
