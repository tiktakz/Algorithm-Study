package inflearnv2;
import java.util.*;

class Inf0609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int start = Arrays.stream(arr).max().getAsInt(); // 최소 시작은 최대값만큼(해당 DVD 담아야함)
        int end = Arrays.stream(arr).sum(); // 최대값은 전체 DVD의 길이. 넘으면 필요없음. 최소값을 구하기 때문

        while (start <= end) {
            int mid = (start + end)/2;
            if (count(arr, mid) <= m) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return answer;
    }
    public static int count(int[] arr, int capacity) {
        int count = 1;
        int sum = 0;

        for (int x : arr) {
            if (sum + x > capacity) {
                count++;
                sum = x;
            }
            else sum += x;
        }

        return count;
    }
}
