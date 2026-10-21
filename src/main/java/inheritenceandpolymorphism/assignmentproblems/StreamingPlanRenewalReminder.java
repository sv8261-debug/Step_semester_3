
package inheritenceandpolymorphism.assignmentproblems;

import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int validityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int validityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SubscriptionPlan> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    subscribers.add(
                            new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(
                            new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(
                            new PremiumPlan(name, startDate));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid plan type");
            }
        }

        for (SubscriptionPlan plan : subscribers) {
            System.out.println(plan.name + ": "
                    + plan.calculateRenewalDate());
        }

        sc.close();
    }
}
