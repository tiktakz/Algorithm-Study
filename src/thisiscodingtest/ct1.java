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

        int group = 0; // 만들 수 있는 그룹의 수
        int player = 0; // 현재 있는 플레이어의 수

        for (int i=0; i<n; i++) {
            player++;
            if (player >= list.get(i)) {
                player = 0; // 현재 공포도와 플레이어의 수가 같으면 다시 초기화하고
                group++; // 그룹을 하나 만든다
            }
        }

        System.out.println(group);
    }
}