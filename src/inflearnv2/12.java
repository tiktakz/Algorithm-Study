package inflearnv2;
import java.util.Scanner;

class problem12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
        sc.close();
    }

    public static String solution(int n, String str) {
        String answer = ""; // 해독한 암호를 담을 정답
        
        // 암호는 7개단위로 이루어져있고, n개만큼의 문자이기 때문에 n번 반복하여
        // 암호를 해독하고 바로 answer에 담아준다
        for (int i=0; i<n; i++) {
            String tmp = str.substring(0,7).replace("#", "1").replace("*", "0"); // substring()메소드를 통해서 7개 단위로 자르고 #,*을 각각 1과 0으로 적절하게 치환한다
            int tmpNum = Integer.parseInt(tmp,2); // 2진수를 10진수로 바꿈
            answer += (char)tmpNum; // 10진수를 해당하는 문자로 바꿈
            str = str.substring(7); // 7번째 문자열 이전까지 다 자르고 for문 반복
        }

        return answer;
    }
}
