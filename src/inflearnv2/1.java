package inflearnv2;
import java.util.Scanner;

class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(solution(str, c));
        sc.close();
    }

    static int solution(String str, char c) {
        int answer = 0;
        c = Character.toLowerCase(c);
        str = str.toLowerCase();
        for(char i: str.toCharArray()) {
            if (i==c) {
                answer++;
            }
        }
        return answer;
    }
}
