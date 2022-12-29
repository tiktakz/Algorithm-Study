package thisiscodingtest;
import java.util.*;

class CT1002 {
    public static int n,m;
    public static int[] parent = new int[100001];

    // 집합찾기
    public static int findParent(int x) {
        if (x != parent[x]) return parent[x] = findParent(parent[x]);
        return x;
    }

    // 두 원소가 속한 집합 찾기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=0; i<m; i++) {
            int operation = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // operation = 0 union
            // operation = 1 같은팀 체크
            if (operation == 0) {
                unionParent(a,b);
            }
            else if (operation == 1) {
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
        }
    }
}
