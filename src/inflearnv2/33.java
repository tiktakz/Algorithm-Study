package inflearnv2;
import java.util.*;

class problem33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n,k,arr));
    }   

    public static ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        // 우선 k-1 길이만큼 해쉬맵에 담아준다
        for (int i=0; i<k-1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i],0) +1);
        }

        int lt = 0;
        // rt 포인터는 k-1부터 시작하여 해쉬맵에 담아준다
        // 처음 넣고 해쉬맵의 사이즈를 보면 몇개의 매출액이 있는지 나온다.
        // 이후 lt=0 이기 때문에 lt번째에 있는 값을 하나 줄인다.
        // 해당 value가 0이면 해당 매출액은 없는 것이지 삭제를 해주어야한다.
        for (int rt = k-1; rt<n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt],0)+1);
            answer.add(hm.size());
            hm.put(arr[lt], hm.get(arr[lt])-1);
            if (hm.get(arr[lt]) == 0) {
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

}
