package inflearnv2;
import java.util.Scanner;
import java.util.ArrayList;

class problem25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i<m; i++) {
            arr2[i] = sc.nextInt();
        }
        sc.close();
        for (int i : solution(n,m,arr1,arr2)) {
            System.out.print(i + " ");
        }
    }    

    public static ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        // 배열이 이미 오름차순으로 정렬되어있어야한다.
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 두개의 포인터를 통해서 각각의 배열을 탐색하는 방법이다.
        // pi는 arr1, pj는 arr2를 탐색한다
        int pi = 0;
        int pj = 0;

        // 배열 다 탐색해야하므로 각각 배열의 길이보다 작을때까지 계속 반복하며
        // 더 작은 숫자를 먼저 넣고 그 숫자가 해당한 배열의 포인터를 1증가시켜준다
        while (pi<n && pj<m) {
            if (arr1[pi] < arr2[pj]) {
                answer.add(arr1[pi]);
                pi++;
            }
            else {
                answer.add(arr2[pj]);
                pj++;
            } 
        }

        // 배열 두 개 중 하나는 탐색이 끝나게 될 것이다. 
        // 배열은 오름차순으로 정렬되어있으니 남아있는 배열은 그냥 차례대로 추가해주면 된다
        // 어떤 배열이 먼저 남을지 모르기 때문에 둘다 추가해주면 된다.
        while (pi<n) {
            answer.add(arr1[pi++]);
        }

        while (pj<m) {
            answer.add(arr2[pj++]);
        }

        return answer;
    }
}
