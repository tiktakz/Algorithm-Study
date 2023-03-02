import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static int[] operations;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        for (int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }
        operations = new int[4];
        // + - * /
        for (int i=0; i<4; i++) {
            operations[i] = sc.nextInt();
        }
        
        dfs(numbers[0],1,0);
        System.out.println(max);
        System.out.println(min);
        
    }
    
    public static void dfs(int start, int depth, int result) {
        if (depth == n) {
            min = Math.min(min, start);
            max = Math.max(max, start);
            return;
        }
        for (int i=0; i<4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                switch(i) {
                    case 0:
                        dfs(start+numbers[depth], depth+1);
                        break;
                    case 1:
                        dfs(start-numbers[depth], depth+1);
                        break;
                    case 2:
                        dfs(start*numbers[depth], depth+1);
                        break;
                    case 3:
                        dfs(start/numbers[depth], depth+1);
                        break;
                }
                operations[i]++;
            }
        }
    }
}
