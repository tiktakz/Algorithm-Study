package inflearnv2;
import java.util.*;

class Inf0608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(binarysearch(arr, m));

    }

    public static int binarysearch(int[] arr, int find) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == find) return mid+1;
            else if (arr[mid] > find) {
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return -1; // 찾지 못함
    }
}
