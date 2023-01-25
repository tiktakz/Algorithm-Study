package baekjoon;
import java.util.*;

class BJ1931 {
    static class Meetings implements Comparable<Meetings> {
        // 회의 종료시간이 빠른 회의를 먼저 해야 제일 많은 회의를 진행할 수 있음
        // 그렇기 때문에 회의를 정렬하고 회의정보(시작, 종료시간)을 담기 위해서 새로운 클래스 만듬
        int startTime, endTime;
        public Meetings(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        @Override
        public int compareTo(Meetings other) {
            // 만약 종료시간이 같으면 시작 시간이 더 짧은것을 선택해야함
            if (this.endTime == other.endTime) return this.startTime - other.startTime;
            return this.endTime - other.endTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meetings> meetings = new ArrayList<>(); // 회의정보를 담을 객체배열
        for (int i=0; i<n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meetings(start, end));
        }

        Collections.sort(meetings);

        int count = 0; // 진행할 수 있는 회의 개수
        int end_time = 0; // 처음에는 아무 회의도 없으니 종료시간이 0
        // 회의 개수 만큼 반복

        for (Meetings meeting : meetings) {
            // 새로운 미팅의 시작 시간이 종료시간 보다 크다면, 미팅 진행 가능하다는 뜻
            if (meeting.startTime >= end_time) {
                count++; // 회의 수 증가
                end_time = meeting.endTime; // 종료시간은 새로 시작한 회의의 종료시간으로 변경
            }
        }

        System.out.println(count);
    }
}
