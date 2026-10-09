import java.util.Scanner;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    private final int units;

    SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    private final int units;
    private final int occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    private final int units;

    ACRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10.0) + 200;
    }
}

public class A3_HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    room = new ACRoom(units);
                    break;
                default:
                    continue;
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}