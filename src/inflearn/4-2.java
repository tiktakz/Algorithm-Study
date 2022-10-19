package inflearn;
import java.util.*;

class Main4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str1 = sc.next();

        System.out.println(solution(str, str1));
    }

    public static String solution(String str, String str1) {
        String answer = "YES";
        HashMap<Character,Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (char x : str1.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x)-1);
        }

        return answer;

    }
}