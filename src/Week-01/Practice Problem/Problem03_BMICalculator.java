import java.util.Scanner;

public class Problem03_BMICalculator {

    public static String getStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25) {
            return "Normal";
        }
        else if (bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        double[] heights = new double[n];
        double[] weights = new double[n];
        double[] bmi = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter name: ");
            names[i] = sc.next();

            System.out.print("Enter height in meters: ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight in kg: ");
            weights[i] = sc.nextDouble();

            bmi[i] = weights[i] / (heights[i] * heights[i]);
        }

        System.out.println("\nBMI Results:");

        for (int i = 0; i < n; i++) {

            System.out.printf("%s | Height: %.2f | Weight: %.2f | BMI: %.2f | %s\n",
                    names[i],
                    heights[i],
                    weights[i],
                    bmi[i],
                    getStatus(bmi[i]));
        }

        sc.close();
    }
}