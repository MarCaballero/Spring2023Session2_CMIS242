class Orange extends Fruit {
    // Maria Caballero - I added this attribute which will be unique for the Orange
    // superclass
    private final double ORANGE_FEE = 2.99;

    /**
     * Maria Caballero - I added this constructor to represent Overriding
     * 
     * @Overriding = Same constructor method in both superclasses (Apple and Orange)
     * @param amountPurchased
     */
    public Orange(int amountPurchased) {
        super.totalPrice = amountPurchased * ORANGE_FEE;
        System.out.println("Your total orange purchase is = " + String.format("%.2f", totalPrice));
    }

    public void taste() {
        System.out.println("This oranges are juicy and tangy.");
    }
}
