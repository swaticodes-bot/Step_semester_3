public class A5_ShoppingCart {

    private final double[] prices;
    private int itemCount;
    private final String cartId;

    public A5_ShoppingCart(String cartId, int maximumItems) {
        this.cartId = cartId;
        prices = new double[maximumItems];
        itemCount = 0;
    }

    public void addItem(double price) {

        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {

        A5_ShoppingCart cart =
                new A5_ShoppingCart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}