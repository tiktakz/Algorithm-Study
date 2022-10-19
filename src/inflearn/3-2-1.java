package inflearn;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main3_2_1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr1 = new int[m];
        for (int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        sc.close();

        for (int i : solution(n,m,arr,arr1)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr1) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(arr1);

        int pt = 0, pt1 = 0;

        while (pt<n && pt1<m) {
            if (arr[pt] == arr1[pt1]) {
                answer.add(arr[pt]);
                pt++;
                pt1++;
            }
            else if (arr[pt] < arr1[pt1]) {
                pt++;
            }
            else {
                pt1++;
            }
        }
        return answer;
    }
}