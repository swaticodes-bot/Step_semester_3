import java.util.Scanner;

abstract class Cab {
    protected double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    boolean supportsNightService() {
        return false;
    }

    double calculateFare(boolean isNight) {
        double fare = distance * getRate();

        if (fare < 100) {
            fare = 100;
        }

        if (isNight && supportsNightService()) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

class MiniCab extends Cab {

    MiniCab(double distance) {
        super(distance);
    }

    @Override
    double getRate() {
        return 10;
    }
}

class SedanCab extends Cab {

    SedanCab(double distance) {
        super(distance);
    }

    @Override
    double getRate() {
        return 14;
    }

    @Override
    boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab {

    SUVCab(double distance) {
        super(distance);
    }

    @Override
    double getRate() {
        return 18;
    }

    @Override
    boolean supportsNightService() {
        return true;
    }
}

public class A4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            boolean isNight = time.equals("NIGHT");
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
                    System.out.println("Invalid cab type");
                    continue;
            }

            if (isNight && !cab.supportsNightService()) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(isNight);

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}