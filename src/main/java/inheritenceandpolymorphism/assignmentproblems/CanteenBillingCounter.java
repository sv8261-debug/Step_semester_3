
package inheritenceandpolymorphism.assignmentproblems;

import java.util.*;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 0.90;
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 0.95;
    }

    @Override
    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + 10;
    }

    @Override
    String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    bills.add(new Student(amount));
                    break;
                case "STAFF":
                    bills.add(new Staff(amount));
                    break;
                case "GUEST":
                    bills.add(new Guest(amount));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }
        }

        double total = 0;

        for (Customer customer : bills) {
            double finalAmount = customer.calculateAmount();
            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
