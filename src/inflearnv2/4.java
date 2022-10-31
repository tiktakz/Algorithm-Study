package inflearnv2;
import java.util.Scanner;

class problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strArr = new String[N];
        for (int i=0; i<N; i++) {
            strArr[i] = sc.next(); 
        }
        sc.close();
        System.out.println("풀이 1");
        solution(N, strArr);
        System.out.println("풀이 2");
        solution2(N, strArr);
    }

    public static void solution(int N, String[] strArr) {
        // char 배열로 만들어서 두개의 포인터 lt, rt를 사용하여 위치를 교환한다
        // lt는 배열의 첫번째 원소부터, rt는 배열의 끝부터 시작하여 
        // lt++, rt--를 통해 서로 계속 위치를 바꾸다가 lt가 rt보다 커지면 전부 교환한 것이므로
        // while (lt < rt) 까지만 실행해준다
        for (String str : strArr) {
            char[] charArr = str.toCharArray();
            int lt = 0;
            int rt = str.length() - 1;

            while (lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(charArr);
        }
    }

    public static void solution2 (int N, String[] strArr) {
        // StringBuilder의 .reverse() 메소드를 사용하여 풀어보기
        for (String str : strArr) {
            String answer = new StringBuilder(str).reverse().toString();
            System.out.println(answer);
        }
    }
}

