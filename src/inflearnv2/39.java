package inflearnv2;
import java.util.*;

class problem39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        sc.close();
    }    

    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } 
            else {
                stack.pop(); // ) 닫는 괄호 만나니 '(' pop 시킴
                if (str.charAt(i-1) == '(') {
                    answer += stack.size();
                }
                else {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
