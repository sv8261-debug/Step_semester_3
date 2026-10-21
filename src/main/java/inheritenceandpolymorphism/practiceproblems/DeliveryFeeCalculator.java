
package inheritenceandpolymorphism.practiceproblems;

import java.util.*;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance,
                          double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2.00 * weight)
                + (0.50 * distance) + customsFee;
    }

    @Override
    String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0];
            double weight = Double.parseDouble(data[1]);
            double distance = Double.parseDouble(data[2]);

            switch (type) {
                case "STANDARD":
                    deliveries.add(
                            new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(
                            new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customsFee =
                            Double.parseDouble(data[3]);
                    deliveries.add(new InternationalDelivery(
                            weight, distance, customsFee));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unknown delivery type: " + type);
            }
        }

        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n",
                    delivery.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
