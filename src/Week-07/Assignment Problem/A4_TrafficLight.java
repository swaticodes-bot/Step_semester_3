public class A4_TrafficLight {

    private String color;
    private final String id;

    public A4_TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {

        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {

        A4_TrafficLight light =
                new A4_TrafficLight("TL-9");

        System.out.println(light.getColor());

        light.next();
        System.out.println(light.getColor());

        light.next();
        System.out.println(light.getColor());

        light.next();
        System.out.println(light.getColor());
    }
}