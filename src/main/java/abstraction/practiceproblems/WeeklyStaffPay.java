
package abstraction.practiceproblems;

import java.util.*;

abstract class StaffMember {
    protected String name;

    StaffMember(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StaffMember> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    staffList.add(
                            new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY":
                    staffList.add(new HourlyStaff(
                            name, sc.nextDouble(), sc.nextDouble()));
                    break;
                case "INTERN":
                    staffList.add(
                            new InternStaff(name, sc.nextDouble()));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }
        }

        double total = 0;

        for (StaffMember staff : staffList) {
            double pay = staff.calculatePay();
            System.out.printf("%s: %.2f%n", staff.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
