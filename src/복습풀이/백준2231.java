import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<n-2; i++) {
            if (arr[i] > m) continue;
            for (int j=i+1; j<n-1; j++) {
                if (arr[i] + arr[j] > m) continue;
                for (int k=j+1; k<n; k++) {
                    int tmpsum = arr[i] + arr[j] + arr[k];
                    if (tmpsum == m) {
                        max = tmpsum;
                        break;
                    }
                    if (tmpsum > max && tmpsum <= m) {
                        max = tmpsum;
                    }
                }
            }
        }
        
        System.out.println(max);
    }
}
