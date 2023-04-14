public class MexicanRestaurant extends Restaurant {
    //making the constructor by calling the super class given the attributes
    public MexicanRestaurant() {
        super("El Torito", "Mexican", 20);
    }
    @Override
    //Overriding the abstract method of addReservation
        //As you can see though, this method is using the same paramenter as the displayReservations method.
            //Therefore, we could not use the same method name to make use of polymorphism of Overloading
    public void makeReservation(int numReservations) {
        super.reservations[super.numReservations] = numReservations;
        super.numReservations++;
        
    }
    @Override
    //Overriding the abstract methods
    public void displayReservations(int numReservations) {
        System.out.println("----------" + super.name + "----------");
        if(numReservations < super.numTables){
            System.out.println("You have successfully reserved " +  super.reservations[super.numReservations - 1] + " tables. Thank you!");
        }else{
            System.out.println("Sorry, no reservations available for more than 20 tables.");
        }
    }
}
