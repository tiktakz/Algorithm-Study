package baekjoon;
import java.util.*;

class BJ1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i=0; i<n; i++) str[i] = sc.nextLine();

        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else return s1.length() - s2.length();
            }
        });
        System.out.println(str[0]);
        for (int i=1; i<n; i++) {
            if (!str[i].equals(str[i-1])) {
                System.out.println(str[i]);
            }
        }
    }
}