package baekjoon;
import java.util.*;

class Main10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        int[] alphabet = new int[26];

        for (int i=0; i<str.length(); i++) {
            alphabet[str.charAt(i) - 97]++;
        }

        for (int i=0; i<alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }    
}
