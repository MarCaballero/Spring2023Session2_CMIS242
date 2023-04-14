//Purpose: This class is used to create FruitSnack objects which are a type of Snack object
public class FruitSnack extends Snack{
    //Additional attributes
    protected Boolean isCitrus;
    private static final double FLAT_ADDITIONAL_FEE = 5.99;
    //Constructor for the FruitSnack class
    public FruitSnack(){
        super();
        this.isCitrus = false;
    }
    //This method is used to set the price of the FruitSnack object 
    //based on the size of the snack and if it has citrus it adds a flat fee
    public void setPrice(Boolean isCitrus, String size){
        super.setPrice(size);
        if(isCitrus){
            super.price = super.price + FLAT_ADDITIONAL_FEE;
        }
    }
}