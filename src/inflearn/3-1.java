package inflearn;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// 안좋은 방법
class Main3_1{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int [] arr1 = new int[M];
        for (int i=0; i<M; i++) {
            arr1[i] = sc.nextInt();
        }
        
        sc.close();

        for (int i : solution(arr, arr1)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution(int[] arr, int[] arr1) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++) {
            answer.add(arr[i]);
        }
        for (int i=0; i<arr1.length; i++) {
            answer.add(arr1[i]);
        }
        Collections.sort(answer);
        return answer;
    }
}

// two pointer Algorithm

class twopointers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int [] arr1 = new int[m];
        for (int i=0; i<m; i++) {
            arr1[i] = sc.nextInt();
        }
        sc.close();
        for (int i : solution(n, m, arr, arr1)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr1) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int p1 = 0; 
        int p2 = 0;
    
        while (p1<n && p2<m) {
            if (arr[p1] < arr1[p2]) {
                answer.add(arr[p1++]);
            }
            else {
                answer.add(arr1[p2++]);
            }
        }
        
        while (p1<n) {
            answer.add(arr[p1++]);
        }

        while (p2<m) {
            answer.add(arr1[p2++]);
        }

        return answer;
    }
}