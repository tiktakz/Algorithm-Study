package inflearnv2;
import java.util.*;

class problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n,str));
        sc.close();
    }

    public static char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> hm = new HashMap<>(); // key는 Char, Value는 Int
        
        for (char c : str.toCharArray()) {
            hm.put(c, hm.getOrDefault(c,0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (char c : hm.keySet()) {
            if (hm.get(c) > max) {
                // get()은 해당 키에 맞는 값을 가져옴
                max = hm.get(c);
                answer = c;
            }
        }

        return answer;
    }
}
