package inflearnv2;
import java.util.*;

class Inf1102 {
    static class Time implements Comparable<Time> {
        int start, end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time other) {
            if (this.end == other.end) return this.start - other.start;
            else return this.end - other.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            al.add(new Time(s, e));
        }

        int count = 0;
        int end = 0;
        Collections.sort(al);
        for (Time time : al) {
            if (time.start >= end) {
                count++;
                end = time.end;
            }
        }
        System.out.println(count);
    }
}
