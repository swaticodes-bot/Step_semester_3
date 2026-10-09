import java.time.LocalDate;
import java.util.Scanner;

interface SubscriptionPlan {
    int getValidityDays();
}

class BasicPlan implements SubscriptionPlan {
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan implements SubscriptionPlan {
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan implements SubscriptionPlan {
    public int getValidityDays() {
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
                    plan = new BasicPlan();
                    break;
                case "STANDARD":
                    plan = new StandardPlan();
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan();
                    break;
                default:
                    continue;
            }

            LocalDate renewalDate =
                    startDate.plusDays(plan.getValidityDays());

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}