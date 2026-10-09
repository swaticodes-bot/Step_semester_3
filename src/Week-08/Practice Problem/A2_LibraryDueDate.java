import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
}

class Bike implements Vehicle {
    private final int hours;

    Bike(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car implements Vehicle {
    private final int hours;

    Car(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck implements Vehicle {
    private final int hours;

    Truck(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return Math.max(hours * 50.0, 100.0);
    }
}

public class A2_ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                case "TRUCK":
                    vehicle = new Truck(hours);
                    break;
                default:
                    continue;
            }

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}