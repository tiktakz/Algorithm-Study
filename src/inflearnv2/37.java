package inflearnv2;
import java.util.*;

class problem37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] boards = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                boards[i][j] = sc.nextInt();
            }
        }
        int M = sc.nextInt();
        int[] moves = new int[M];
        for (int i=0; i<M; i++) {
            moves[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(boards, moves));
    }

    public static int solution(int [][] boards, int [] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i=0; i<boards.length; i++) {
                if (boards[i][pos-1] != 0) {
                    int tmp = boards[i][pos-1];
                    boards[i][pos-1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    }
                    else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        } // for1

        return answer;
    }
}