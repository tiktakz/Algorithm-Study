package inflearnv2;
import java.util.*;

class coord implements Comparable<coord> {
    private int x;
    private int y;

    public coord (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(coord other) {
        if (this.x != other.x) {
            return this.x - other.x;
        }
        else if (this. x == other.x) {
            return this.y - other.y;
        }
        return 0;
    }
}



class Inf0607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<coord> al = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            al.add(new coord(x, y));
        }

        Collections.sort(al);

        for (coord coords : al) {
            System.out.println(coords.getX() + " " + coords.getY());
        }
    }
}
