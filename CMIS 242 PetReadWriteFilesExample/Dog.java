public class Dog extends Pet{

    // attributes
    private String chipID;

    // constructor
    public Dog(int id, String name, String chipID){
        super(id, name);
        this.chipID = chipID;
    }

    // constructor to parse string with xml tags for its values
    public Dog(String line){
        super(line);
        chipID = line.substring(line.indexOf("<chipID>") + 8, line.indexOf("</chipID>"));
    }

    // get method for chipID
    public String getChipID(){
        return chipID;
    }

    // set method for chipID
    public void setChipID(String chipID){
        this.chipID = chipID;
    }
    
    // toString method
    public String toString(){
        return "<Dog>"
                + "<id>" + getId() + "</id>"
                + "<name>" + getName() + "</name>"
                + "<chipID>" + chipID + "</chipID>"
                + "</Dog>";
    }
}