package baekjoon;
import java.util.*;
import java.io.*;

class Main11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2) -> {
            int n1 = Math.abs(o1);
            int n2 = Math.abs(o2);
            
            if (n1 == n2) {
                return o1 > o2 ? 1 : -1;
            }
            else {
                return n1 - n2;
            }
        });

        for (int i=0; i<n; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request==0) {
                if (Q.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(Q.poll());
                }
            } 
            else {
                Q.offer(request);
            }
        
        }
    }
}