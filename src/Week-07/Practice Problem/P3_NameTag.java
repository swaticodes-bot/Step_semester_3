public final class P3_NameTag {

    private final String firstName;
    private final String lastName;

    public P3_NameTag(String fullName) {
        String[] nameParts = fullName.split(" ");

        firstName = nameParts[0];
        lastName = nameParts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {

        P3_NameTag tag = new P3_NameTag("Maria Gomez");

        System.out.println("Nickname: " + tag.getNickname());
    }
}