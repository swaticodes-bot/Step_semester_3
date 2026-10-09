import java.util.Scanner;

abstract class Parcel {
    protected double weight;

    Parcel(double weight) {
        this.weight = weight;
    }

    abstract double calculateCharge();

    double calculateInsurance(double declaredValue) {
        return 0.0;
    }

    double calculateTotal(double declaredValue) {
        return calculateCharge() + calculateInsurance(declaredValue);
    }
}

interface Insurable {
    double calculateInsurance(double declaredValue);
}

class StandardParcel extends Parcel {

    StandardParcel(double weight) {
        super(weight);
    }

    @Override
    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight) {
        super(weight);
    }

    @Override
    double calculateCharge() {
        return 80 + 15 * weight;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight) {
        super(weight);
    }

    @Override
    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class A2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight);
                    break;

                default:
                    System.out.println("Invalid parcel type");
                    continue;
            }

            double charge = parcel.calculateCharge();

            double insurance = 0.0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel)
                        .calculateInsurance(declaredValue);
            }

            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}