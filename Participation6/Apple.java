class Apple extends Fruit {
    // Maria Caballero - I added this attribute which will be unique for the Apple
    // superclass
    private final double APPLE_FEE = 3.15;

    /**
     * Maria Caballero - I added this constructor to represent Overriding
     * 
     * @Overriding = Same constructor method in both superclasses (Apple and Orange)
     * @param amountPurchased
     */
    public Apple(int amountPurchased) {
        super.totalPrice = amountPurchased * APPLE_FEE;
        System.out.println("Your total apple purchase is = " + String.format("%.2f", totalPrice));
    }

    public void taste() {
        System.out.println("This apples are sweet and crunchy.");
    }
}
    
    

