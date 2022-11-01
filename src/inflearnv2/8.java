package inflearnv2;
import java.util.Scanner;

class problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str);
        sc.close();
    }

    public static void solution(String str) {
        // replaceAll() 메소드를 활용해서 문가 아닌것들은 제거하고 시작
        // 나머지 알고리즘은 7번문제와 동일
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        int lt = 0;
        int rt = str.length() - 1;
        String answer = "YES";
        while (lt < rt ) {
            char start = str.charAt(lt);
            char end = str.charAt(rt);
            if (start != end) {
                answer = "NO";
                break;
            }
            lt++;
            rt--;
        }
        System.out.println(answer);
    }
}