package inflearnv2;
import java.util.*;

class Inf1101 {
    static class Status implements Comparable<Status>{
        int height, weight;
        public Status(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Status other) {
            return other.height - this.height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Status> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            al.add(new Status(h, w));
        }

        Collections.sort(al);

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Status stat : al) {
            if (stat.weight > max) {
                max = stat.weight;
                count++;
            }
        }

        System.out.println(count);
    }


}
