package inflearnv2;

import java.util.ArrayList;
import java.util.Scanner;

class Inf0301 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr1 = new int[N];
        for (int i=0; i<N; i++) {
            arr1[i] = scan.nextInt();
        }
        int M = scan.nextInt();
        int[] arr2 = new int[M];
        for (int i=0; i<M; i++) {
            arr2[i] = scan.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        int pt1 = 0;
        int pt2 = 0;

        while(pt1 < N && pt2 < M) {
            if (arr1[pt1] < arr2[pt2]) {
                list.add(arr1[pt1++]);
            }
            else {
                list.add(arr2[pt2++]);
            }
        }

        while (pt1 < N) {
            list.add(arr1[pt1++]);
        }

        while (pt2 < M) {
            list.add(arr2[pt2++]);
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
