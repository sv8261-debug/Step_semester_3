
package abstraction.assignmentproblems;

import java.util.*;

abstract class Student {
    private static final double TRANSPORT_FEE = 12000.0;
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();
    abstract boolean usesBus();

    final double calculateTotalFee() {
        double fee = calculateTuition();

        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 40000.0;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 40000.0 + 60000.0;
    }

    @Override
    boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 20000.0;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }

        double total = 0;

        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
