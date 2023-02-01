package baekjoon;
import java.util.*;

class BJ18310 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            al.add(sc.nextInt());
        }

        Collections.sort(al);
        int mid = n/2;
        System.out.println(al.get(mid-1));
    }
}
