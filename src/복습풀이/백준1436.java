import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int title = 666;
        int count = 1;
        
        while (count != n) {
            title++;
            if (String.valueOf(title).contains("666")) {
                count++;
            }
        }
        System.out.println(title);
    }
}
