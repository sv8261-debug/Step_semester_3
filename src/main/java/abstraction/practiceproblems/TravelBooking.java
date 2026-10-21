package abstraction.practiceproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBookingBase {
    protected double distance;

    TravelBookingBase(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class BusBooking extends TravelBookingBase {
    BusBooking(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 2;
    }

    @Override
    String getType() {
        return "Bus";
    }
}

class TrainBooking extends TravelBookingBase {
    TrainBooking(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 1.5;
    }

    @Override
    String getType() {
        return "Train";
    }
}

class FlightBooking extends TravelBookingBase {
    FlightBooking(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 8;
    }

    @Override
    String getType() {
        return "Flight";
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TravelBookingBase> bookings = new ArrayList<>();

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter booking type (BUS/TRAIN/FLIGHT): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            switch (type) {
                case "BUS":
                    bookings.add(new BusBooking(distance));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distance));
                    break;
                default:
                    System.out.println("Invalid booking type. Skipped.");
            }
        }

        double totalFare = 0;

        System.out.println("\n--- Travel Booking Report ---");

        for (TravelBookingBase booking : bookings) {
            double fare = booking.calculateFare();
            System.out.printf("%s: Rs. %.2f%n",
                    booking.getType(), fare);
            totalFare += fare;
        }

        System.out.printf("Total Fare: Rs. %.2f%n", totalFare);

        sc.close();
    }
}