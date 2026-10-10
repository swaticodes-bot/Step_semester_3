import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    String getShape() {
        return "TRIANGLE";
    }
}

public class P1_GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();

            switch (shape) {
                case "CIRCLE":
                    plots[i] = new Circle(owner, sc.nextDouble());
                    break;

                case "RECTANGLE":
                    plots[i] = new Rectangle(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;

                case "TRIANGLE":
                    plots[i] = new Triangle(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;

                default:
                    System.out.println("Invalid shape");
                    sc.close();
                    return;
            }
        }

        for (Plot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;

            System.out.printf(
                    "%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}