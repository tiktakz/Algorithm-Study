package inflearnv2;
import java.util.*;


class problem26 {
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
        for (int i : solution(n,m,arr,arr1)) {
            System.out.print(i + " ");
        }
        sc.close();
    }
    
    public static ArrayList<Integer> solution (int n, int m, int[] arr, int[] arr1) {
        ArrayList<Integer> al = new ArrayList<>();
        // 배열 탐색 포인터 선언
        int p1 = 0;
        int p2 = 0;

        // 배열을 오름차순으로 정렬해야 공통 원소 찾을 수 있게 포인터 사용 가능
        Arrays.sort(arr);
        Arrays.sort(arr1);

        // 배열 전체를 탐색
        // arr[p1] 의 값이 arr[p2] 보다 크면 배열은 오름차순 정렬 되어있기 때문에 
        // arr[p2]의 현재 위치보다 이전에 있는 값은 절대로 arr[p1]과 같은 숫자가 있을 수 없다.
        // 그래서 p2++ 를 해주고 반대로 arr[p1]이 arr1[p2] 보다 작으면 p1++ 해줘야한다.
        while (p1<n && p2<m) {
            if (arr[p1] == arr1[p2]) {
                al.add(arr[p1]);
                p1++;
                p2++;
            }
            else if (arr[p1] > arr1[p2]) {
                p2++;
            }
            else if (arr[p1] < arr1[p2]) {
                p1++;
            }
        }

        return al;

    }
}
