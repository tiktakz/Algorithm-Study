import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] info = new int[n][2];
        
        for (int i=0; i<n; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
        }
        
        for (int i=0; i<n; i++) {
            int rank = 1;
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (info[j][0] > info[i][0] && info[j][1] > info[i][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
