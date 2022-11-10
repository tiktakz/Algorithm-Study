package inflearnv2;
import java.util.*;

class problem34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();
        System.out.println(solution(str1, str2));
    }   

    // 33번 문제와 아주 유사한 풀이
    // 같이 참고하면 됨
    

    public static int solution(String str1, String str2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int answer = 0;

        for (char key : str2.toCharArray()) {
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }

        for (int i=0; i<str2.length()-1; i++) {
            hm2.put(str1.charAt(i), hm2.getOrDefault(str1.charAt(i),0)+1);
        }

        int lt = 0;

        for (int rt=str2.length()-1; rt<str1.length(); rt++) {
            hm2.put(str1.charAt(rt), hm2.getOrDefault(str1.charAt(rt),0)+1);
            if (hm.equals(hm2)) {
                answer++;
            }
            hm2.put(str1.charAt(lt), hm2.get(str1.charAt(lt))-1);
            if (hm2.get(str1.charAt(lt)) == 0) {
                hm2.remove(str1.charAt(lt));
            }
            lt++;
        }

        return answer;
    }
}
