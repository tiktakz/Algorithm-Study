package inflearnv2;
import java.util.*;

class Inf0605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        HashMap<Integer, Integer> hm = new HashMap<>();

        boolean flag = false;

        for (int i=0; i<n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
            if(hm.get(arr[i]) >= 2) {
                flag = true;
                break;
            }
        }

        if (flag) System.out.print("D");
        else System.out.print("U");
    }
}
