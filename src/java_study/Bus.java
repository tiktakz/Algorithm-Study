package java_study;

public class Bus {
    int busNumber;
    int passengerCount;
    int money;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }

    // 승객태움
    public void take(int money) {
        this.passengerCount++;
        this.money += money;
    }

    public void showInfo() {
        System.out.println("버스 " + busNumber + "번의 승객은 " + passengerCount + "명, 수입은" + money + "원 입니다" );
    }
}
