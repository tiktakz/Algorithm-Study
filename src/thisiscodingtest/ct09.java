package thisiscodingtest;
import java.util.*;

// 프로그래머스에서 제공되는 문제
// 문자열 압축

class ct09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = s.length();
        // 문자열의 길이 / 2 만큼 반복
        for (int i=1; i<s.length()/2 + 1; i++) {
            int count = 1; // 압축된 문자만큼 숫자가 필요함.
            // 확인할 패턴(문자열), 처음부터 자른다고 했으니 0부터 i까지 확인
            String pattern = s.substring(0, i);
            StringBuilder compressedString = new StringBuilder(); // 완성된 압축 문자열
            // j는 패턴길이만큼 확인해야되기 때문에 j+=i 를 통해서 패턴길이만큼 확인
            for (int j = i; j <= s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String tmp = s.substring(j, end);
                // 확인하는 패턴과 똑같은 패턴이 있다면 count 증가
                if (pattern.equals(tmp)) count++;
                else {
                    // 같은 패턴이 안나오고 2이상이면, 문자열에 count 개수 적어줘야함
                    if (count >= 2) {
                        compressedString.append(count);
                    }
                    // 확인된 패턴 문자열에 추가함
                    compressedString.append(pattern);
                    // 새로운 패턴이 뒤에 있는지 확인하기 위해서 다시 넣어주고
                    pattern = tmp;
                    count = 1; // 다시 패턴개수 초기화
                }
            }
            compressedString.append(pattern);
            //System.out.println(compressedString);
            answer = Math.min(answer, compressedString.length());
        }
    }
}
