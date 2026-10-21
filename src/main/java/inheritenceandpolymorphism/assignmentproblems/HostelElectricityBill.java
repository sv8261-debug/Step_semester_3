
package inheritenceandpolymorphism.assignmentproblems;

import java.util.*;

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8.0;
    }

    @Override
    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    String getType() {
        return "SHARED";
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 10.0 + 200;
    }

    @Override
    String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new AcRoom(units));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid room type");
            }
        }

        double total = 0;

        for (Room room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
