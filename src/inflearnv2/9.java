package inflearnv2;
import java.util.Scanner;

class problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solution(str);
        solution2(str);
        sc.close();
    }

    public static void solution(String str) {
        // replaceAll 메소드로 숫자가 아닌 문자는 모두 제외하고 
        // 첫번째 숫자가 0인경우 자연수가 아니기 때문에 정수로 변환해 주는 Integer.ParseInt()사용
        str = str.replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(str));
    }

    public static void solution2(String str) {
        // StringBuilder을 사용하여 str에 있는 문자 하나하나 검사하여
        // isDigit(c) == true 일때만 추가한다. 마찬가지로 마지막에 Integer.ParseInt() 사용해서 정수로 변환한다
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
