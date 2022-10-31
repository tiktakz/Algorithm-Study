package inflearnv2;
import java.util.*;

class problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        solution(str);
    }

    public static void solution(String str) {
        /* 
        StringBuilder로 .reverse와 equals를 사용하는 방법말고 다른 풀이를 사용해보았다.
        팰린드롬은 앞에서 읽으나 뒤에서 읽으나 같은 문자이기 때문에
        주어진 문자열의 첫과 끝을 비교하며 시작한다. 둘이 다르면 애초에 팰린드롬이 될 수 없으니 바로 NO
        만약 같다면 포인터 두개를 사용해 하나는 문자열의 앞부터, 하나는 뒤쪽부터 따라오며 서로 비교를 한다
        모든 탐색을 마쳤다면 팰린드롬이기에 YES를 출력한다.
        ** 대소문자를 구분하지 않기때문에 우선 문자열을 LowerCase 혹은 UpperCase로 바꾸어주고 시작했다.
        */
        int lt = 0;
        int rt = str.length()-1;
        str = str.toLowerCase();
        String answer = "YES";

        while (lt < rt) {
            char start = str.charAt(lt);
            char end = str.charAt(rt);

            if (start != end) {
                answer = "NO";
                break;
            }
            lt++;
            rt--;
        }
        System.out.println(answer);
    }
}