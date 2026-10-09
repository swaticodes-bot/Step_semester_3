import java.util.Scanner;

interface Employee {
    double calculateBonus();
}

class FullTimeEmployee implements Employee {
    private final double salary;

    FullTimeEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee implements Employee {
    private final double salary;

    PartTimeEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    public double calculateBonus() {
        return 2000.0;
    }
}

public class A4_FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(salary);
                    break;
                case "INTERN":
                    employee = new Intern();
                    break;
                default:
                    continue;
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}