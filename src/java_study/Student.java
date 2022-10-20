package java_study;

public class Student {
    String studentName;
    int grade;
    int money;

    public Student(String studentName, int money) {
        this.studentName = studentName;
        this.money = money;
    }

    // method
    // 버스 정보를 매개변수로 받음
    public void takeBus(Bus bus) {
        bus.take(1000);
        money -= 1000;
    }

    public void takeSubway(Subway subway) {
        subway.take(1500);
        money -= 1500;
    }

    public void showInfo() {
        System.out.println(studentName + "님의 잔액 : " + money + "원");
    }
}
