package baekjoon;
import java.util.*;

class BJ1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i<n; i++) arr1[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i<m; i++) arr2[i] = sc.nextInt();

        // 이진탐색을 위해 정렬
        Arrays.sort(arr1);

        for (int i=0; i<m; i++) {
            boolean find = false;
            int target = arr2[i];
            int start = 0;
            int end = arr1.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr1[mid] == target) {
                    System.out.println(1);
                    find = true;
                    break;
                }
                else if (arr1[mid] > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            if (!find) System.out.println(0);
        }

    }
}
