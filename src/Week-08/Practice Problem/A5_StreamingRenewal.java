import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class Basic extends SubscriptionPlan {
    Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 30;
    }
}

class Standard extends SubscriptionPlan {
    Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class Premium extends SubscriptionPlan {
    Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class A5_StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new Basic(name, startDate);
                    break;
                case "STANDARD":
                    plan = new Standard(name, startDate);
                    break;
                case "PREMIUM":
                    plan = new Premium(name, startDate);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plan type");
            }

            System.out.println(
                    name + ": " + plan.calculateRenewalDate());
        }

        sc.close();
    }
}