package thisiscodingtest;
import java.util.*;

class ct1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        int player = 0;
        int groups = 0;

        for (int i=0; i<n; i++) {
            player++; // 그룹참가자 한명을 넣고, 참가자의 수와 현재 공포도를 비교
            // 만약 공포도랑 현재 참가자가 같다면 바로 그룹을 결성하면, 최소 인원으로 그룹을 결성
            // 즉 많은 그룹을 만들 수 있음.
            if (player >= list.get(i)) {
                groups++;
                player = 0;
            }
        }
        System.out.println(groups);
    }
}