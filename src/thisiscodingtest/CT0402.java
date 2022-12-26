package thisiscodingtest;

import java.util.Scanner;

public class CT0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // 예시입력 a1 (a는 열, 1은 행)
        int row = input.charAt(1) - '0';
        int column = input.charAt(0) - 'a' + 1; // 열은 a ~ h 이지만 계산하기 쉽게 숫자로 나타냄. 즉 a1 = 11

        /**
         *         말이 움직일 수 있는 규칙에 의하면 가능한 좌표의 이동은 총 8가지이다
         *          moves = {(1,2), (-1,2), (2,1), (2,-1), (-1,-2), (1,-2), (-2,-1), (-2,1)}
         *          x축 dx, y축 dy는 각각
         *          dx = {1,-1,2,2,-1,1,-2,-2}
         *          dy = {2,2,1,-1,-2,-2,-1,1}
         *
         */

        int[] dx = {1,-1,2,2,-1,1,-2,-2};
        int[] dy = {2,2,1,-1,-2,-2,-1,1};
        int answer = 0;

        // 최대 가능 조합이 8개이기에 8번만 반복해도 됨
        for (int i=0; i<8; i++) {
            // 움직이는 좌표를 계산하고 그 좌표가 판 8x8 안에 있는지 확인한다.
            int newRow = row + dx[i];
            int newColumn = column + dy[i];
            if (newRow >=1 && newRow <=8 && newColumn >=1 && newColumn <=8) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
