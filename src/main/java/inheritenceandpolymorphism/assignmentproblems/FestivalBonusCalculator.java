
package inheritenceandpolymorphism.assignmentproblems;

import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees.add(
                            new FullTimeEmployee(name, salary));
                    break;
                case "PARTTIME":
                    employees.add(
                            new PartTimeEmployee(name, salary));
                    break;
                case "INTERN":
                    employees.add(new Intern(name, salary));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid employee type");
            }
        }

        double total = 0;

        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            System.out.printf("%s: %.2f%n",
                    employee.name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
