package thisiscodingtest;
import java.util.*;

class ct3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int count1 = 0; // 1 변경 횟수
        int count2 = 0; // 2 변경 횟수

        if (str.charAt(0)-'0' == 0) count1++;
        else count2++;

        for (int i=0; i<str.length()-1; i++) {
            // 다음 숫자가 바뀐다면 (0->1 , 1->0)
            if (str.charAt(i) != str.charAt(i+1)) {
                // 1이면 count1++, 0이면 count2++
                if (str.charAt(i+1) == '1') count1++;
                else count2++;
            }
        }

        // 최소 횟수 구해야함
        int result = Math.min(count1, count2);
        System.out.println(result);
    }
}
