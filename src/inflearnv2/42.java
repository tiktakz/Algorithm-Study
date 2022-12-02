package inflearnv2;
import java.util.*;

class problem42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n,m,arr));
    }    

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            Q.offer(new Person(i, arr[i]));
        }

        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person p : Q) {
                if (p.danger > tmp.danger) {
                    Q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }
}

class Person {
    int id;
    int danger;
    Person(int id, int danger) {
        this.id = id;
        this.danger = danger;
    }
}


