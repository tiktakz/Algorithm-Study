package thisiscodingtest;
import java.util.*;

class ct07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int length = num.length()/2;

        int left = 0;
        int right = 0;

        for (int i=0; i<length; i++) {
            left += num.charAt(i) - '0';
        }

        for (int i=length; i<num.length(); i++) {
            right += num.charAt(i) - '0';
        }

        if (left == right) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
