package inflearnv2;
import java.util.Scanner;

class problem10 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char t = sc.next().charAt(0);
        solution(str, t);   
        sc.close();
    }

    public static void solution(String str, char t) {
        // 문자열의 길이는 100을 넘지 않음
        int[] answer = new int[str.length()]; // 정답은 숫자로 나와야함. 또한 문자마다의 거리이기 때문에 str길이만큼의 배열을 생성
        int pointer = 1000; // 최대 길이가 100이기 때문에 그것보다 훨씬 큰 숫자로 포인터를 초기화해놓는다

        // 한번은 배열을 좌 -> 우측으로 두번째로는 우->좌측으로 탐색하며
        // 더 작은 값을 정답배열 answer에 담으면 해당 문자와의 떨어진 거리를 찾을 수 있을 것이다.
        for (int i=0; i<str.length(); i++) {
            // 문자를 탐색하며 해당 문자가 찾는 문자 t이면 pointer을 0으로 초기화 시킨다
            // 자기 자리에 해당 문자면 떨어진 거리가 0이기 때문이다.
            if (str.charAt(i) == t) {
                pointer = 0;
                answer[i] = pointer;
            }
            else {
                pointer++;
                answer[i] = pointer;
            }
        }

        pointer = 1000; // 다시 순회해야하기 때문에 1000으로 초기화

        // 반대로 순회
        for (int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) == t) {
                pointer = 0;
                // answer[i] = pointer; 0인 경우에는 반대나 정방향이나 무조건 0이기 때문에 다시 안바꿔줘도 된다
            }
            else {
                pointer++;
                answer[i] = Math.min(answer[i], pointer); // 기존의 있던 거리와 새로 찾은 거리 중에서 더 작은 값으로 대치해서 넣어야한다
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}