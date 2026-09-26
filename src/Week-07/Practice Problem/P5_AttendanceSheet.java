public class P5_AttendanceSheet {

    private final String[] presentStudents;
    private int presentCount;

    public P5_AttendanceSheet(int maximumClassSize) {
        presentStudents = new String[maximumClassSize];
        presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (isPresent(studentName)) {
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = studentName;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(studentName)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        P5_AttendanceSheet sheet = new P5_AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}