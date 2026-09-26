public class A3_PasswordChecker {

    private final String password;

    public A3_PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {

        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {

        A3_PasswordChecker pc =
                new A3_PasswordChecker("abcd");

        System.out.println(
                "Password strength: " + pc.getStrength()
        );

        A3_PasswordChecker pc2 =
                new A3_PasswordChecker("abcdefghij");

        System.out.println(
                "Password strength: " + pc2.getStrength()
        );
    }
}