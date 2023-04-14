public abstract class Restaurant {
    //attributes
    public int numTables; //number of tables it has
    public int numReservations; //number of current reservations
    public int reservations[]; //keeps track of reservations
    public String cuisine; //cuisine of the restaurant
    public String name; //name of the restaurant

    //constructor
    public Restaurant(String name, String cuisine, int numTables) {
        this.name = name;
        this.cuisine = cuisine;
        this.numTables = numTables;
        this.numReservations = 0;
        this.reservations = new int[numTables];
    }
    
    //abstract method to add new reservation
    public abstract void makeReservation(int numReservations);

    //abstract method to display information about all reservations
    public abstract void displayReservations(int numReservations);
}