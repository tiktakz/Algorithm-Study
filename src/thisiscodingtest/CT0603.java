package thisiscodingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}


class CT0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> al = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            al.add(new Student(name, score));
        }

        Collections.sort(al);

        for (Student student : al) {
            System.out.print(student.getName() + " ");
        }
    }
}
