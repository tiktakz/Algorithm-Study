package inflearnv2;
import java.util.*;

class problem32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1,str2));
        System.out.println(solution2(str1,str2));

        sc.close();
    }    

    public static String solution(String str1, String str2) {
        // 풀이 1
        // 두개의 해쉬맵을 만들어 각각 str1, str2를 담아 .equals()를 사용해서 비교
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (char key : str1.toCharArray()) {
            hm1.put(key, hm1.getOrDefault(key, 0)+1);
        }

        for (char key : str2.toCharArray()) {
            hm2.put(key, hm2.getOrDefault(key, 0)+1);
        }

        if (hm1.equals(hm2)) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

    public static String solution2(String str1, String str2) {
        // 풀이 2
        // 첫문자열을 해쉬맵에 담고 두번째 문자열에서 해쉬맵에 있는 문자 제거하는 식
        // 두번째 문자열에서 같은 키 값을 만나면 -1을 해준다.
        // 해당 키 값이 0이라면 존재하지 않기 때문에 아나그램이 아님. 
        // 또한 해당 키가 아예 존재 하지 않아도 아나그램이 아님.
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char key : str1.toCharArray()) {
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }

        for (char key : str2.toCharArray()) {
            if (!hm.containsKey(key) || hm.get(key) == 0) {
                return "NO";
            }
            hm.put(key, hm.get(key)-1);
        }

        return "YES";

    }
}
