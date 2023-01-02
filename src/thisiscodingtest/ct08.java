package thisiscodingtest;

import java.util.*;

class ct08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Character> al = new ArrayList<>();

        int sum = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) al.add(c);
            else sum += c -'0';
        }

        Collections.sort(al);

        for (char c : al) {
            System.out.print(c);
        }

        System.out.print(sum);
    }
}
