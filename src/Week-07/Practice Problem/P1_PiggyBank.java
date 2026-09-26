public class P1_PiggyBank {

    private double savings;
    private final String id;

    public P1_PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal rejected.");
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {

        P1_PiggyBank piggyBank = new P1_PiggyBank("PB-1");

        piggyBank.deposit(100);
        System.out.println("Savings after deposit: " + piggyBank.getSavings());

        piggyBank.withdraw(30);
        System.out.println("Savings after withdrawal: " + piggyBank.getSavings());

        piggyBank.withdraw(500);
        System.out.println("Final savings: " + piggyBank.getSavings());
    }
}