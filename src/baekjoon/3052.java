package baekjoon;
import java.util.*;
// 배열
class Main3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        HashSet<Integer> hs = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            hs.add(arr[i] % 42);
        }

        System.out.println(hs.size());
    }    
}
