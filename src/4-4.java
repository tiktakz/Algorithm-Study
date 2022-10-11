import java.util.Scanner;
import java.util.HashMap;

class Main4_4 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String k = sc.next();
        sc.close();
        System.out.println(solution(str,k));
    }

    public static int solution (String str, String k) {
        int answer = 0;
        HashMap<Character,Integer> a = new HashMap<>(); // 정답체크용
        HashMap<Character,Integer> b = new HashMap<>(); // 기본

        for (char c : k.toCharArray()) {
            b.put(c, b.getOrDefault(c,0)+1);
        }

        int l = k.length()-1;
        for (int i=0; i<l; i++) {
            a.put(str.charAt(i), a.getOrDefault(str.charAt(i),0)+1);
        }

        int lt = 0;
        for (int rt=l; rt<str.length(); rt++) {
            a.put(str.charAt(rt), a.getOrDefault(str.charAt(rt),0)+1);
            if (a.equals(b)) {
                answer++;
            }
            a.put(str.charAt(lt), a.get(str.charAt(lt))-1);
            if (a.get(str.charAt(lt)) == 0) {
                a.remove(str.charAt(lt));
            }
            lt++;
        }

        return answer;
    }
}