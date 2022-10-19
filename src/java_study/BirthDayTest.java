package java_study;

class BirthDayTest {
    public int day;
    private int month;
    int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (month == 2) {
            if (day<1 || day>28) {
                System.out.println("날짜 오류");
            }
        }
        else {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printThis() {
        System.out.println(this);
    }
}

class thisExample {
    public static void main(String[] args) {
        BirthDayTest b1 = new BirthDayTest();
        BirthDayTest b2 = new BirthDayTest();
        System.out.println("b1" + b1);
        b1.printThis();
        System.out.println("b2" + b2);
        b2.printThis();
    }
}
