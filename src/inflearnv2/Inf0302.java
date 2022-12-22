package inflearnv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Inf0302 {
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
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int pt1 = 0;
        int pt2 = 0;

        while (pt1 < N && pt2 < M) {
            if (arr1[pt1] == arr2[pt2]) {
                list.add(arr1[pt1++]);
                pt2++;
            }
            else if (arr1[pt1] < arr2[pt2]) {
                pt1++;
            }
            else pt2++;
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
