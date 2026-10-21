
package inheritenceandpolymorphism.practiceproblems;

import java.util.*;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return Math.min(2 + (0.10 * distance), 10);
    }

    @Override
    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Transport> journeys = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0];
            double distance = Double.parseDouble(data[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                case "METRO":
                    double factor = Double.parseDouble(data[2]);
                    journeys.add(new Metro(distance, factor));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unknown transport type: " + type);
            }
        }

        for (Transport journey : journeys) {
            double fare = journey.calculateFare();

            System.out.printf("%s: %.2f%n",
                    journey.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
