import java.util.Scanner;

interface Transport {
    double calculateFare();
}

class Bus implements Transport {

    private final double distance;

    public Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return Math.min(2 + (0.10 * distance), 10);
    }
}

class Train implements Transport {

    private final double distance;

    public Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro implements Transport {

    private final double distance;
    private final double peakFactor;

    public Metro(double distance, double peakFactor) {
        this.distance = distance;
        this.peakFactor = peakFactor;
    }

    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakFactor;
    }
}

public class A5_TransportFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            switch (type) {

                case "BUS":
                    transport = new Bus(distance);
                    break;

                case "TRAIN":
                    transport = new Train(distance);
                    break;

                case "METRO":
                    double peakFactor = sc.nextDouble();
                    transport = new Metro(distance, peakFactor);
                    break;

                default:
                    continue;
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}