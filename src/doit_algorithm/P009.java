package doit_algorithm;
import java.util.Scanner;
import java.util.Arrays;

class P009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] charArr = new char[n];
        for (int i=0; i<n; i++) {
            charArr[i] = sc.next().charAt(0);
        }
    }    
}
