package doit_algorithm;
import java.util.Scanner;
import java.util.Arrays;
// 백준(1253번) 책(008)
class P008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        int answer = 0;

        for (int k=0; k<n; k++) {
            int lp = 0;
            int rp = arr.length-1;
            int find = arr[k];

            while (lp < rp) {
                if (arr[lp] + arr[rp] == find) {
                    if (arr[lp] != arr[rp]) {
                        answer++;
                        break;
                    }
                    else if (k == lp) {
                        lp++;
                    }
                    else if (k == rp) {
                        rp--;
                    }
                }
                else if (arr[lp] + arr[rp] > find) {
                    rp--;
                }
                else {
                    lp++;
                }
            }
        }

        System.out.println(answer);

    }
}
