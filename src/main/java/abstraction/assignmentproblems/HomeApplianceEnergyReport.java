
package abstraction.assignmentproblems;

import java.util.*;

interface SaverMode {
    double reduceUnits(double units);
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();
    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    final double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 150.0;
    }

    @Override
    String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 1500.0;
    }

    @Override
    String getType() {
        return "AC";
    }

    @Override
    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 100.0;
    }

    @Override
    String getType() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 500.0;
    }

    @Override
    String getType() {
        return "WASHER";
    }

    @Override
    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Appliance> appliances = new ArrayList<>();
        List<Boolean> saverRequests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String type = data[0];
            double hours = Double.parseDouble(data[1]);
            boolean saver = data.length == 3
                    && data[2].equals("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid appliance type");
            }

            appliances.add(appliance);
            saverRequests.add(saver);
        }

        double totalCost = 0;

        for (int i = 0; i < appliances.size(); i++) {
            Appliance appliance = appliances.get(i);
            boolean saver = saverRequests.get(i);

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(appliance.getType()
                        + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).reduceUnits(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
