package baekjoon;
import java.util.*;

public class BJ2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            al.add(sc.nextInt());
        }
        Collections.sort(al);

        // 이진탐색
        // 공유기 사이의 최소거리는 1, 최대 거리는 배열에서의 가장 큰 값(즉 마지막 값)
        int lt = 1;
        int rt = al.get(n-1);
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt+rt) / 2;
            // c개 이상 배치 가능하면 간격을 더 늘려본다
            if (count(al, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            }
            // 그렇지 않다면 간격을 좁힌다
            else rt = mid - 1;
        }

        System.out.println(answer);
    }

    public static int count(ArrayList<Integer> al, int mid) {
        int count = 1; // 공유기 처음 1개 설치
        int pos = al.get(0); // 맨 왼쪽에 있는 곳에 설치해야 최대거리 가능

        for (int i=0; i<al.size(); i++) {
            if (al.get(i) - pos >= mid) {
                count++;
                pos = al.get(i);
            }
        }
        return count;
    }
}
