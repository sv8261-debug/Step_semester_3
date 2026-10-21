
package abstraction.assignmentproblems;

import java.util.*;

interface NightService {
    double applyNightSurcharge(double fare);
}

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateBaseFare();
    abstract String getType();

    final double calculateFare(boolean night) {
        double fare = Math.max(calculateBaseFare(), 100.0);

        if (night) {
            if (!(this instanceof NightService)) {
                return -1;
            }

            fare = ((NightService) this).applyNightSurcharge(fare);
        }

        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    @Override
    double calculateBaseFare() {
        return km * 10.0;
    }

    @Override
    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    @Override
    double calculateBaseFare() {
        return km * 14.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }

    @Override
    String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    @Override
    double calculateBaseFare() {
        return km * 18.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }

    @Override
    String getType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Cab> cabs = new ArrayList<>();
        List<Boolean> nightTrips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }

            cabs.add(cab);
            nightTrips.add(time.equals("NIGHT"));
        }

        double total = 0;

        for (int i = 0; i < cabs.size(); i++) {
            Cab cab = cabs.get(i);
            double fare = cab.calculateFare(nightTrips.get(i));

            if (fare < 0) {
                System.out.println(cab.getType()
                        + ": night service not available");
            } else {
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
