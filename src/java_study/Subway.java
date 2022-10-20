package java_study;

public class Subway {
    int subwayNumber;
    int passengerCount;
    int money;

    public Subway(int subwayNumber) {
        this.subwayNumber = subwayNumber;
    }

    // 승객태움
    public void take(int money) {
        passengerCount++;
        this.money += money;
    }

    public void showInfo() {
        System.out.println("지하철 " + subwayNumber + "번의 승객은 " + passengerCount + "명, 수입은" + money + "원 입니다" );
    }
}
