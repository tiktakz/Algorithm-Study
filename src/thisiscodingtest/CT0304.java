package thisiscodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CT0304 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int k = Integer.parseInt(bf.readLine());

        int answer = 0;

        while (n >= k) {
            while (n%k != 0) {
                n--;
                answer++;
            }
            n /= k;
            answer++;
        }

        while (n > 1) {
            n--;
            answer++;
        }

        System.out.println(answer);
    }
}
