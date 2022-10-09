import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        for (int i=0; i<m; i++) {
            arr1[i] = sc.nextInt();
        }
        sc.close();

        for (int i : solution(n, m, arr, arr1)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr1) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        int p1 = 0, p2 = 0;

        while (p1<n && p2<m) {
            if (arr[p1] == arr1[p2]) {
                answer.add(arr[p1]);
                p1++;
                p2++;
            }
            else if (arr[p1] < arr1[p2]) {
                p1++;
            }
            else {
                p2++;
            }
        }

        return answer;
    }
}