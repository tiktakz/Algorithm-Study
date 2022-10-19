package inflearn;

import java.util.Scanner;

//review
class Main1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i=0; i<n; i++) {
            str[i] = sc.next(); 
        }
        solution(n, str);
    }

    public static void solution(int n, String[] str) {
        for (String s : str) {
            char[] chArr = s.toCharArray();
            int lt = 0;
            int rt = s.length()-1;

            while (lt < rt) {
                char temp = chArr[lt];
                chArr[lt] = chArr[rt];
                chArr[rt] = temp;
                lt++;
                rt--;
            }
            String answer = String.valueOf(chArr);
            System.out.println(answer);
        }
    }

}