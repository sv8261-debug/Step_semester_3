
package abstraction.assignmentproblems;

import java.util.*;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();
    abstract String getSeatType();

    final double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 150.0;
    }

    @Override
    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 250.0;
    }

    @Override
    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 400.0;
    }

    @Override
    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            switch (seat) {
                case "REGULAR":
                    tickets.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    tickets.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    tickets.add(new ReclinerTicket(count));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n",
                    ticket.getSeatType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
