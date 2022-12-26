package thisiscodingtest;

import java.util.*;
import java.io.*;

class CT0303 {
    public static void main(String args[]) throws IOException{
        long startTime = System.currentTimeMillis();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int result = 0;

        int[][] arr = new int [n][m];
        for (int i=0; i<n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<m; j++) {
                int temp = Integer.parseInt(bf.readLine());
                min = Math.min(min, temp);
            }
            result = Math.max(result, min);
        }

        System.out.println(result);
        long endTime = System.currentTimeMillis();

        long durationTimeSec = endTime - startTime;
        System.out.println((durationTimeSec / 1000) + "sec");
    }
}