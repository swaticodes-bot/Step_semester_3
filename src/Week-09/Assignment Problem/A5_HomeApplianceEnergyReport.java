import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    protected double power;

    Appliance(double hours, double power) {
        this.hours = hours;
        this.power = power;
    }

    double calculateUnits() {
        return (power * hours) / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }

    boolean supportsSaverMode() {
        return false;
    }

    double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours, 150);
    }
}

class AC extends Appliance {
    AC(double hours) {
        super(hours, 1500);
    }

    @Override
    boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours, 100);
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours, 500);
    }

    @Override
    boolean supportsSaverMode() {
        return true;
    }
}

public class A5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saverMode = false;

            if (sc.hasNext()) {
                sc.skip("[ \t]*");
                if (sc.hasNext("SAVER")) {
                    sc.next();
                    saverMode = true;
                }
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AC(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours);
                    break;

                default:
                    System.out.println("Invalid appliance");
                    continue;
            }

            if (saverMode && !appliance.supportsSaverMode()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;

            if (saverMode) {
                units = appliance.calculateSaverUnits();
            } else {
                units = appliance.calculateUnits();
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}