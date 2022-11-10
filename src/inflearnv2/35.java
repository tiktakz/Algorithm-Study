package inflearnv2;
import java.util.*;

class problem35 {
    //Treeset - 중복도 제거하고 정렬도 함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr,n,k));
        sc.close();
    }    

    public static int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
        
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int l=j+1; l<n; l++) {
                    tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int count = 0;
        for (int x : tset) {
            count++;
            if (count == k) {
                return x;
            }
        }
        return answer;
    }
}
