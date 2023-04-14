// Purpose: This class is used to create SaltySnack objects which are a type of Snack object
public class SaltySnack extends Snack{
    //Additional attributes
    protected Boolean isNut;
    private static final double FLAT_ADDITIONAL_FEE = 4.50;
    //Constructor for the SaltySnack class
    public SaltySnack(){
        super();
        this.isNut = false;
    }
    //This method is used to set the price of the SaltySnack object 
    //based on the size of the snack and if it has nuts it adds a flat fee
    public void setPrice(Boolean isNut, String size){
        super.setPrice(size);
        if(isNut){
            super.price = super.price + FLAT_ADDITIONAL_FEE;
        }
    }
}
