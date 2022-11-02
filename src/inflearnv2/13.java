package inflearnv2;
import java.util.Scanner;
import java.util.ArrayList;

// 2-01
class problem13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) { arr[i] = sc.nextInt(); }
        solution(arr);
        sc.close();
    }

    public static void solution (int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(arr[0]); // 배열의 첫번째 숫자는 자신 앞의 숫자가 없기때문에 무조건 포함시킨다

        for (int i=1; i<arr.length; i++) {
            // arr[0]은 이미 저장이 되어있으니 1부터 돌면된다
            if (arr[i] > arr[i-1]) {
                al.add(arr[i]);
            }
        }

        for (int i : al) {
            System.out.print(i + " ");
        }
    }
}
