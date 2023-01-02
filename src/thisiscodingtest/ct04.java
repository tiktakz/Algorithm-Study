package thisiscodingtest;

import java.util.*;

class ct04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] money = new int[n];
        for (int i=0; i<n; i++) money[i] = sc.nextInt();

        Arrays.sort(money);
        int target = 1;

        for (int coin : money) {
            if (coin > target) break; // 못만듬
            target += coin;
        }
        System.out.println(target);
    }
}
