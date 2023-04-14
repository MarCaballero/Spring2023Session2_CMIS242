import java.util.UUID; //This package is used to generate random ID's for the snacks

//Parent class Snack
public class Snack {
    //Size is protected because it is used in the subclasses
    protected String size;
    //For the ID of the snack, we use UUID to generate a random ID that contains random numbers and letters
    //and it is private because it is unique for each snack
    private UUID id;
    //Price is protected because it is used in the subclasses for those snacks that have additional fees
    protected double price;
    //Flat fees for each snack size as constants
    public static final double FLAT_FEE_SMALL_SIZE = 19.99;
    public static final double FLAT_FEE_MEDIUM_SIZE = 29.99;
    public static final double FLAT_FEE_LARGE_SIZE = 39.99;

    //Constructor for the Snack class
    public Snack(){
        this.id = UUID.randomUUID();
        this.size = "0";
        this.price = 0;
    }

    //Getters method for the variables
    public UUID getID(){
        return id;
    }
    public String getSize(){
        return size;
    }
    public Double getPrice(){
        return price;
    }
    //Setters method for the variables
    public void setID(){
        id = UUID.randomUUID();
    }
    public void setSize(String size){
        this.size = size;
    }
    //The price is calculated based on the size of the snack
    public void setPrice(String size){
        if(size.equals("S")){
            this.price = price + FLAT_FEE_SMALL_SIZE;
        }
        else if(size.equals("M")){
            this.price = price + FLAT_FEE_MEDIUM_SIZE;
        }
        else if(size.equals("L")){
            this.price = price + FLAT_FEE_LARGE_SIZE;
        }
        else{
            System.out.println("Invalid size. Please enter a valid size.");
        }
    }
}
