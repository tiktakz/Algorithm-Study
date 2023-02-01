package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ10825 {
    static class Score implements Comparable<Score>{
        int lang, eng, math;
        String name;
        public Score(String name, int lang, int eng, int math) {
            this.lang = lang;
            this.eng = eng;
            this.math = math;
            this.name = name;
        }
        @Override
        public int compareTo(Score other) {
            if (this.lang == other.lang) {
                if (this.eng == other.eng) {
                    if (this.math == other.math) {
                        return this.name.compareTo(other.name);
                    }
                    return other.math - this.math;
                }
                return this.eng - other.eng;
            }
            return other.lang - this.lang;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Score> al = new ArrayList<>();
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int lang = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            al.add(new Score(name, lang, eng, math));
        }

        Collections.sort(al);
        for (Score s : al) {
            System.out.println(s.name);
        }
    }
}
