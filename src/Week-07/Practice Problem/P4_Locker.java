public class P4_Locker {

    private final int lockerNumber;
    private String combinationCode;

    public P4_Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {

        P4_Locker locker = new P4_Locker(101, "1234");

        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
    }
}