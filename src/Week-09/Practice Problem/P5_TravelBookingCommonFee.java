import java.util.Scanner;

abstract class TravelBooking {
    static final double BOOKING_FEE = 50.0;

    double distanceKm;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {
    Bus(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateFare() {
        return distanceKm * 2.0;
    }
}

class Train extends TravelBooking {
    Train(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateFare() {
        return distanceKm * 1.5;
    }
}

class Flight extends TravelBooking {
    Flight(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateFare() {
        return 2500 + (distanceKm * 4.0);
    }
}

public class P5_TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;

                default:
                    System.out.println("Invalid travel mode");
                    sc.close();
                    return;
            }
        }

        for (TravelBooking booking : bookings) {
            String mode = booking.getClass().getSimpleName()
                    .toUpperCase();

            System.out.printf(
                    "%s: %.2f%n",
                    mode, booking.calculateTotal());
        }

        sc.close();
    }
}